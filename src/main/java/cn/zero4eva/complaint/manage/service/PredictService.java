package cn.zero4eva.complaint.manage.service;

import cn.zero4eva.complaint.manage.mapper.IPredictCaseInfoMapper;
import cn.zero4eva.complaint.manage.pojo.PredictCaseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PredictService extends BaseService<PredictCaseInfo> {

    @Autowired
    private IPredictCaseInfoMapper predictCaseInfoMapper;

    @Autowired
    private CaseInfoService caseInfoService;

    @Autowired
    private RecommendService recommendService;

    /**
     * 根据案件全称查询获取预测所需信息，然后预测信访等级，而后更新信访等级
     * 若中途预测失败，则调用推荐系统
     *
     * @param caseId
     * @return
     */
    public boolean predictAndUpdateSelective(String caseId) {
        PredictCaseInfo predictCaseInfo = super.queryById(caseId);
        String visitLetterLevel = this.predictVisitLetterLevel(predictCaseInfo);
        if (null == visitLetterLevel || "" == visitLetterLevel) {
            this.recommendService.predictAndSaveRecommend(caseId);
            return false;
        }
        return this.caseInfoService.updateSelective(caseId, visitLetterLevel);
    }

    // TODO 预测诉转访风险
    public String predictVisitLetterLevel(PredictCaseInfo predictCaseInfo) {
        return "";
    }
}
