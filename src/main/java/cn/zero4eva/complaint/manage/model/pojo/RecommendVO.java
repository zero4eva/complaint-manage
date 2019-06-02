package cn.zero4eva.complaint.manage.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class RecommendVO {

    private String caseNumber;

    private String courtName;

    private String criminalCase;

    private String judicialProcedure;

    private String closeCause;

    // TODO modify as closeDate
    private Date sluitingsdatum;

    private String chiefJudge;

    private String experts;
}
