package cn.zero4eva.complaint.manage.service;

import cn.zero4eva.complaint.manage.model.entity.ComplaintDO;
import cn.zero4eva.complaint.manage.model.pojo.CasePredictDTO;
import cn.zero4eva.complaint.manage.repository.ComplaintRepository;
import org.springframework.stereotype.Service;

@Service
public class ComplaintService {

    private final ComplaintRepository complaintRepository;

    public ComplaintService(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }


    /**
     * 通过二审案号查询返回案件预测所需信息
     *
     * @param caseId
     * @return
     */
    public CasePredictDTO queryCasePredictInfoByCaseId(String caseId) {
        return new CasePredictDTO(this.queryByCaseId(caseId));
    }


    /**
     * 通过二审案号查询得到案件预测所需信息
     *
     * @param caseId
     * @return
     */
    public ComplaintDO queryByCaseId(String caseId) {
        // 由于数据库用的联合查询后的表，有重复
        // 生产环境中应该是唯一的
        return this.complaintRepository.findFirstByCaseNumber(caseId);
    }
}
