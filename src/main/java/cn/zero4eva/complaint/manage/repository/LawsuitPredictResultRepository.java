package cn.zero4eva.complaint.manage.repository;

import cn.zero4eva.complaint.manage.model.entity.LawsuitPredictResultDO;
import cn.zero4eva.complaint.manage.model.pojo.RecommendVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LawsuitPredictResultRepository extends JpaRepository<LawsuitPredictResultDO, String> {
    /**
     * 联合predict result与lawsuit表，查询获取recommend详细信息
     * 查询预测结果中，预测失败+未被解决的
     *
     * @return
     */
    @Query("SELECT new cn.zero4eva.complaint.manage.model.pojo.RecommendVO(l.caseNumber, l.courtName, l.criminalCase, l.judicialProcedure, l.closeCause, l.sluitingsdatum, l.chiefJudge, r.experts) FROM LawsuitDO l, LawsuitPredictResultDO r WHERE l.caseNumber=r.caseNumber AND r.predictState=false AND r.solved=false")
    public List<RecommendVO> getRecommendList();
}
