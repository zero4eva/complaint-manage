package cn.zero4eva.complaint.manage.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName PredictCaseInfo
 * @Description 预测案件风险所需信息
 * @Author Yang
 * @Date 2019-5-8-0008 22:26
 * @Version 1.0
 **/

@Data
@Table(name = "tb_lawsuit")
public class PredictCaseInfo {
    @Id
    private String caseNumber; //案号全称

//    // 年龄
//    private Integer age;
//
//    // 性别
//    private String sex;
//
//    // 信访次数
//    private Integer letterVisitCount;

    // 案件类别
    private String criminalCase;

    // 案件来源
    private String caseSource;

    // 立案案由
    private String registerReason;

    // 案件分类/风险等级
    private String visitLetterLevel;

//    private String accuser;
//
//    private String accuserId;
//
//    private String defendant;
//
//    private String defendantId;
}
