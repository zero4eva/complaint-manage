package cn.zero4eva.complaint.manage.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_lawsuit")
public class LawsuitDO {

    @Id
    private String caseNumber;

    // 法院名称
    private String courtName;

    // 案件类型
    private String criminalCase;

    // 审判程序
    private String judicialProcedure;

    // 结案案由
    private String closeCause;

    // 结案日期
    // TODO modify as closeDate
    private Date sluitingsdatum;

    // 审判官
    private String chiefJudge;

    // 案件详情，应该是起诉书
    @Transient
    private String caseDetail;
}
