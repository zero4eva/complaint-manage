package cn.zero4eva.complaint.manage.service;

import cn.zero4eva.complaint.manage.algorithm.ComplaintPredict;
import cn.zero4eva.complaint.manage.model.entity.LawsuitPredictResultDO;
import cn.zero4eva.complaint.manage.model.pojo.CasePredictDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AlgorithmService {

    private final ComplaintService complaintService;
    private final LawsuitPredictResultService lawsuitPredictResultService;

    public AlgorithmService(ComplaintService complaintService, LawsuitPredictResultService lawsuitPredictResultService) {
        this.complaintService = complaintService;
        this.lawsuitPredictResultService = lawsuitPredictResultService;
    }


    /**
     * 根据案件全称查询获取预测所需信息，然后预测信访等级，而后更新信访等级
     * 若中途预测失败，则调用推荐系统
     *
     * @param caseId
     * @return boolean 预测成功与否
     */
    public boolean predictAndUpdateSelective(String caseId) throws IOException {
        // 获取预测所需案件信息(tb_tb_visit_letter_lawsuit_innerjoin)
        CasePredictDTO casePredictDTO = this.complaintService.queryCasePredictInfoByCaseId(caseId);
        // 获取预测结果
        String visitLetterLevel = this.getPredictVisitLetterLevel(casePredictDTO);
        // 如果预测不准确，调用推荐系统
        LawsuitPredictResultDO predictResultDO = new LawsuitPredictResultDO(caseId);
        if (null == visitLetterLevel || "" == visitLetterLevel) {
            String experts = this.getPredictExperts();
            this.lawsuitPredictResultService.savePredictResult(
                    predictResultDO
                            .buildPredictState(false)
                            .buildExperts(experts)
            );
            return false;
        }
        // 如果预测成功，更新数据库(tb_lawsuit_predict_result)
        this.lawsuitPredictResultService.savePredictResult(
                predictResultDO
                        .buildPredictState(true)
                        .buildVisitLetterLevel(visitLetterLevel)
        );
        return true;
    }


    // TODO 调用推荐系统，返回专家
    public String getPredictExperts() {
        return ComplaintPredict.predictExperts();
    }


    public String getPredictVisitLetterLevel(CasePredictDTO casePredictDTO) throws IOException {
        return ComplaintPredict.predictVisitLetterLevel(casePredictDTO);
    }
}
