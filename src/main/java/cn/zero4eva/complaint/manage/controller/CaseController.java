package cn.zero4eva.complaint.manage.controller;

import cn.zero4eva.complaint.manage.pojo.CaseInfo;
import cn.zero4eva.complaint.manage.service.CaseInfoService;
import cn.zero4eva.complaint.manage.service.PredictService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName CaseController
 * @Description 查询案件基本信息+当事人信息，修改案件预测值
 * @Author Yang
 * @Date 2019-5-8-0008 16:59
 * @Version 1.0
 **/

@RestController
@RequestMapping("case")
public class CaseController {

    private static ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private PredictService predictService;

    @Autowired
    private CaseInfoService caseInfoService;

//    @Autowired
//    private LitigantService litigantService;

    /**
     * 根据caseNumber查询获取案件基本信息和当事人信息
     *
     * @param caseId
     * @return 返回案件基本信息和当事人信息的json数据
     */
//    @RequestMapping(method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @GetMapping
    public ResponseEntity<CaseInfo> queryCaseById(/*@RequestParam(value = "caseId") */String caseId) {
        try {
            CaseInfo caseInfo = this.caseInfoService.queryCaseInfoById(caseId.trim());
            if (null == caseInfo) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(caseInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
    /*@RequestMapping(method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity<CaseDetail> queryCaseById(@RequestParam(value = "caseId") String caseId) {
        try {
//            boolean predictSuccess = this.predictService.predictAndUpdateSelective(caseId);
//            if (predictSuccess) {
                CaseInfo caseInfo = this.caseInfoService.queryCaseInfoById(caseId.trim());
                LitigantDO litigant = this.litigantService.queryLitigantById(caseInfo.getAccuserId());
                if (null == caseInfo && null == litigant) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                }
                CaseDetail caseDetail = new CaseDetail(caseInfo, litigant);
                return ResponseEntity.ok(caseDetail);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }*/

    /*@RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateCaseById(CaseInfo caseInfo) {
        try {
            Integer count = this.caseInfoService.updateSelective(caseInfo);
            if (1 == count) {
                return ResponseEntity.ok().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }*/

    /**
     * 根据caseNumber更新visitLetterLevel的值
     *
     * @param caseId
     * @param visitLetterLevel
     * @return 状态码+无数据
     */
//    @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public ResponseEntity<Void> updateCaseById(String caseId, String visitLetterLevel) {
        try {
            boolean success = this.caseInfoService.updateSelective(caseId, visitLetterLevel);
            if (success) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
