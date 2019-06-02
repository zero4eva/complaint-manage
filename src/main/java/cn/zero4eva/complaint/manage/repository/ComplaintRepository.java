package cn.zero4eva.complaint.manage.repository;

import cn.zero4eva.complaint.manage.model.entity.ComplaintDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<ComplaintDO, String> {

    public ComplaintDO findFirstByCaseNumber(String caseId);
}
