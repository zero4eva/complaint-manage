package cn.zero4eva.complaint.manage.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_lawsuit_predict_result")
public class LawsuitPredictResultDO {
    @Id
    private String caseNumber;

    private String visitLetterLevel;

    private boolean predictState;

    private boolean solved;

    private String experts;

    public LawsuitPredictResultDO(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public LawsuitPredictResultDO buildVisitLetterLevel(String predictLevel) {
        this.visitLetterLevel = predictLevel;
        return this;
    }

    public LawsuitPredictResultDO buildPredictState(boolean predictState) {
        this.predictState = predictState;
        return this;
    }

    public LawsuitPredictResultDO buildSolved(boolean solved) {
        this.solved = solved;
        return this;
    }

    public LawsuitPredictResultDO buildExperts(String experts) {
        this.experts = experts;
        return this;
    }
}
