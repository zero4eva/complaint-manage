package cn.zero4eva.complaint.manage.service;

import cn.zero4eva.complaint.manage.model.entity.LawsuitPredictResultDO;
import cn.zero4eva.complaint.manage.model.pojo.RecommendVO;
import cn.zero4eva.complaint.manage.repository.LawsuitPredictResultRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LawsuitPredictResultService {

    private final LawsuitPredictResultRepository lawsuitPredictResultRepository;

    public LawsuitPredictResultService(LawsuitPredictResultRepository lawsuitPredictResultRepository) {
        this.lawsuitPredictResultRepository = lawsuitPredictResultRepository;
    }

    /**
     * 查询获取案件的预测结果
     *
     * @param caseId
     * @return
     */
    public LawsuitPredictResultDO queryPredictResultByCaseId(String caseId) {
        Optional<LawsuitPredictResultDO> optional = this.lawsuitPredictResultRepository.findById(caseId);
        return optional.get();
    }

    /**
     * 将案件预测的结果保存
     *
     * @param predictResult
     * @return
     */
    public boolean savePredictResult(LawsuitPredictResultDO predictResult) {
        LawsuitPredictResultDO saveReturn = this.lawsuitPredictResultRepository.save(predictResult);
        return predictResult.equals(saveReturn);
    }

    /**
     * 专家修改预测的案件
     * 需要先查询一次，否则没有赋值的字段会被置空
     *
     * @param toUpdateResult
     * @return
     */
    public boolean updatePredictResult(LawsuitPredictResultDO toUpdateResult) {
        LawsuitPredictResultDO resultDO = this.queryPredictResultByCaseId(toUpdateResult.getCaseNumber());
        return this.savePredictResult(
                resultDO
                        .buildSolved(true)
                        .buildVisitLetterLevel(toUpdateResult.getVisitLetterLevel())
        );
    }

    /**
     * 查询该案件是否被预测过
     *
     * @param caseId
     * @return
     */
    public boolean isPredicted(String caseId) {
        Optional<LawsuitPredictResultDO> optional = this.lawsuitPredictResultRepository.findById(caseId);
        if (!optional.isPresent()) {
            return false;
        }
        return true;
    }

    /**
     * 获取推荐案件的详细信息
     *
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public PageInfo<RecommendVO> listRecommend(Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<RecommendVO> list = this.lawsuitPredictResultRepository.getRecommendList();
        return new PageInfo<>(list);
    }
}
