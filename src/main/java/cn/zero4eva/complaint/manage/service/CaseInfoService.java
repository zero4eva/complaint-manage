package cn.zero4eva.complaint.manage.service;

import cn.zero4eva.complaint.manage.mapper.ICaseInfoMapper;
import cn.zero4eva.complaint.manage.pojo.CaseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName CaseInfoService
 * @Description 案件基本信息
 * @Author Yang
 * @Date 2019-5-8-0008 22:57
 * @Version 1.0
 **/
@Service
public class CaseInfoService extends BaseService<CaseInfo> {

    @Autowired
    private ICaseInfoMapper caseInfoMapper;

    public CaseInfo queryCaseInfoById(String caseId) {
        return super.queryById(caseId);
    }

    public boolean updateSelective(String caseId, String visitLetterLevel) {
        CaseInfo caseInfo = new CaseInfo();
        caseInfo.setCaseNumber(caseId);
        caseInfo.setVisitLetterLevel(visitLetterLevel);
        return 1 == super.updateSelective(caseInfo);
    }


}
