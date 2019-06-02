package cn.zero4eva.complaint.manage.model.pojo;


import cn.zero4eva.complaint.manage.model.entity.ComplaintDO;
import cn.zero4eva.complaint.manage.model.entity.LawsuitPredictResultDO;
import lombok.Data;

import javax.persistence.Transient;

@Data
public class CaseDisplayVO {

    // 案号
    private String caseNumber;

    // 案件类型
    private String criminalCase;

    // 立案原因
    private String registerReason;

    // 审判程序
    private String judicialProcedure;

    // 新房风险级别
    private String visitLetterLevel;

    // 案件详情
    @Transient
    private String caseDetails;

    public CaseDisplayVO(ComplaintDO complaintDO, LawsuitPredictResultDO lawsuitPredictResultDo) {
        this.caseNumber = complaintDO.getCaseNumber();
        this.criminalCase = complaintDO.getCriminalCase();
        this.registerReason = complaintDO.getRegisterReason();
        this.judicialProcedure = complaintDO.getJudicialProcedure();
        this.caseDetails = complaintDO.getCaseDetail();

        // 这个是预测的信访等级
        this.visitLetterLevel = lawsuitPredictResultDo.getVisitLetterLevel();
    }

    // 预测不成功，只展示案件信息
    public CaseDisplayVO(ComplaintDO complaintDO) {
        this.caseNumber = complaintDO.getCaseNumber();
        this.criminalCase = complaintDO.getCriminalCase();
        this.registerReason = complaintDO.getRegisterReason();
        this.judicialProcedure = complaintDO.getJudicialProcedure();
        this.caseDetails = complaintDO.getCaseDetail();
    }
}
