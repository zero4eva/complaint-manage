package cn.zero4eva.complaint.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @ClassName: BaseRepository
 * @Description:
 * @Author: zero4eva
 * @CreateDate: 2019-5-28-0028 15:56
 */
// DOMAIN 是数据库实体类，ID 是数据库实体类的主键。
@NoRepositoryBean
public interface BaseRepository<DOMAIN, ID> extends JpaRepository<DOMAIN, ID> {
}
