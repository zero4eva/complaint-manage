package cn.zero4eva.complaint.manage.service;

import cn.zero4eva.complaint.manage.model.entity.LawsuitDO;
import cn.zero4eva.complaint.manage.repository.LawsuitRepository;

import java.util.Optional;

public class LawsuitService {

    private final LawsuitRepository lawsuitRepository;

    public LawsuitService(LawsuitRepository lawsuitRepository) {
        this.lawsuitRepository = lawsuitRepository;
    }


    /**
     * 查询上诉案件的信息
     *
     * @param caseId
     * @return
     */
    public LawsuitDO queryLawsuitById(String caseId) {
        Optional<LawsuitDO> optional = lawsuitRepository.findById(caseId);
        return optional.get();
    }
}
