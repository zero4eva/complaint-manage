package cn.zero4eva.complaint.manage.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_visit_letter_lawsuit_innerjoin")
public class ComplaintDO {

    // 信访编号
    @Id
    @Column(name = "letter_visit_case_number")
    private String complaintCaseNumber;

    // 二审案号
    private String caseNumber;

    // 年龄
    private String age;

    // 性别
    private String gender;

    // 案件类型
    @Column(name = "lawsuit_criminal_case")
    private String criminalCase;

    // 案件来源
    private String caseSource;

    // 立案原因
    private String registerReason;

// --------------------------------------LawsuitDO------------------------------

    // 案件分类/风险等级
    private String visitLetterLevel;

    // 审判程序
    private String judicialProcedure;

    // 案件详情，应该是起诉书
    @Transient
    private String caseDetail;

    // 结案案由
    private String closeCause;

    // 结案日期
    // TODO modify as closeDate
    private Date sluitingsdatum;

    // 审判官
    private String chiefJudge;

    // 法院名称
    private String courtName;
}
