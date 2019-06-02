package cn.zero4eva.complaint.manage.repository;

import cn.zero4eva.complaint.manage.model.entity.LawsuitDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LawsuitRepository extends JpaRepository<LawsuitDO, String> {
}
