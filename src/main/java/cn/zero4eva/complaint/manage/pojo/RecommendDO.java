package cn.zero4eva.complaint.manage.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @ClassName RecommendDO
 * @Description 推荐信息
 * @Author Yang
 * @Date 2019-5-9-0009 15:17
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
@Table(name = "tb_recommend")
public class RecommendDO {

    @Id
    private String caseNumber;
    private String courtName;

    private String criminalCase;

    private String judicialProcedure;

    private String closeCause;

    // TODO modify as closeDate
    private Date sluitingsdatum;

    private String chiefJudge;

    private String experts;

    public RecommendDO() {
    }



/*    public RecommendDO(RecommendCaseInfo rci, String experts) {
        this.caseNumber = rci.getCaseNumber();
        this.courtName = rci.getCourtName();
        this.criminalCase = rci.getCriminalCase();
        this.judicialProcedure = rci.getJudicialProcedure();
        this.closeCause = rci.getCloseCause();
        this.sluitingsdatum = rci.getSluitingsdatum();
        this.chiefJudge = rci.getChiefJudge();
        this.experts = experts;
    }*/
}
