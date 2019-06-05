package cn.zero4eva.complaint.manage.controller;

import cn.zero4eva.complaint.manage.model.entity.ComplaintDO;
import cn.zero4eva.complaint.manage.model.entity.LawsuitPredictResultDO;
import cn.zero4eva.complaint.manage.model.pojo.CaseDisplayVO;
import cn.zero4eva.complaint.manage.service.AlgorithmService;
import cn.zero4eva.complaint.manage.service.ComplaintService;
import cn.zero4eva.complaint.manage.service.LawsuitPredictResultService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @ClassName CasePredictController
 * @Description 根据案号，预测案件信访级别，修改案件预测值
 * @Author Yang
 * @Date 2019-5-8-0008 16:59
 * @Version 1.0
 **/

@RestController
@RequestMapping("/case")
public class CaseController {

    private final ComplaintService complaintService;
    private final AlgorithmService algorithmService;
    private final LawsuitPredictResultService lawsuitPredictResultService;

    public CaseController(ComplaintService complaintService, AlgorithmService algorithmService, LawsuitPredictResultService lawsuitPredictResultService) {
        this.complaintService = complaintService;
        this.algorithmService = algorithmService;
        this.lawsuitPredictResultService = lawsuitPredictResultService;
    }


    /**
     * 根据案号，预测案件信访等级，而后返回
     *
     * @param caseId
     * @return 返回预测的案件信访分级
     */
    @GetMapping("/predict")
    public ResponseEntity<LawsuitPredictResultDO> predictLevel(String caseId) {
        try {
            boolean predictSuccess = this.algorithmService.predictAndUpdateSelective(caseId);
            if (predictSuccess) {
                LawsuitPredictResultDO predictResultDO = this.lawsuitPredictResultService.queryPredictResultByCaseId(caseId);
                return ResponseEntity.ok().body(predictResultDO);
            } else {
                // 409，处理请求时发生错误
                return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 对于已经被预测过的案件
     * 根据案号，获取案件的基本信息和与预测结果
     *
     * @param caseId
     * @return
     */
    @GetMapping("/prediction")
    public ResponseEntity<CaseDisplayVO> getCaseInfoAndPredictResultById(String caseId) {
        try {
            ComplaintDO complaintDO = this.complaintService.queryByCaseId(caseId);
            boolean isPredicted = this.lawsuitPredictResultService.isPredicted(caseId);
            if (isPredicted) {
                LawsuitPredictResultDO predictResultDO = this.lawsuitPredictResultService.queryPredictResultByCaseId(caseId);
                CaseDisplayVO caseDisplayVO = new CaseDisplayVO(complaintDO, predictResultDO);
                return ResponseEntity.ok().body(caseDisplayVO);
            } else {
                CaseDisplayVO caseDisplayVO = new CaseDisplayVO(complaintDO);
                // 404，该案件未被预测过
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(caseDisplayVO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }


    /**
     * 仅仅查询案件信息
     *
     * @param caseId
     * @return
     */
    @GetMapping
    public ResponseEntity<CaseDisplayVO> getCaseInfoById(String caseId) {
        try {
            ComplaintDO complaintDO = this.complaintService.queryByCaseId(caseId);
            if (null == complaintDO) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            CaseDisplayVO caseDisplayVO = new CaseDisplayVO(complaintDO);
            return ResponseEntity.ok().body(caseDisplayVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 根据caseNumber更新visitLetterLevel的值
     *
     * @param caseId
     * @param visitLetterLevel
     * @return 状态码+无数据
     */
    @PutMapping
    public ResponseEntity<Void> updateCaseById(String caseId, String visitLetterLevel) {
        try {
            LawsuitPredictResultDO resultDO = new LawsuitPredictResultDO(caseId).buildVisitLetterLevel(visitLetterLevel);
            boolean updateSuccess = this.lawsuitPredictResultService.updatePredictResult(resultDO);
            if (!updateSuccess) {
                // 无资源404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
