package cn.zero4eva.complaint.manage.model.pojo;

import cn.zero4eva.complaint.manage.model.entity.ComplaintDO;
import lombok.Data;


@Data
public class CasePredictDTO {

    // 年龄
    private String age;

    // 性别
    private String gender;

    // 案件类型
    private String criminalCase;

    // 案件来源
    private String caseSource;

    // 立案原因
    private String registerReason;

    public CasePredictDTO(ComplaintDO complaintDO) {
        this.age = complaintDO.getAge();
        this.gender = complaintDO.getGender();
        this.caseSource = complaintDO.getCaseSource();
        this.criminalCase = complaintDO.getCriminalCase();
        this.registerReason = complaintDO.getRegisterReason();
    }
}
