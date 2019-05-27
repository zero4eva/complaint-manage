package cn.zero4eva.complaint.manage.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



@Data
@Table(name = "tb_lawsuit")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CaseInfo {
    @Id
    private String caseNumber; //案号全称

    // 案件类别
    private String criminalCase;

    // 立案原因
    private String registerReason;

    // 审判程序
    private String judicialProcedure;

    // 案件分类/风险等级
    private String visitLetterLevel;

    @Transient
    private String caseDetail;

/*    private String accuser;

    private String accuserId;

    private String defendant;

    private String defendantId;*/
}
