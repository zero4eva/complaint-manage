package cn.zero4eva.complaint.manage.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;



public abstract class BaseService<T> {

    @Autowired
    private Mapper<T> mapper;

    // 根据主键查询数据
    public T queryById(Object obj) {
        return this.mapper.selectByPrimaryKey(obj);
    }

    // 查询所有数据
    public List<T> queryAll() {
        return this.mapper.select(null);
    }

    // 根据record查询单个数据
    public T queryOne(T record) {
        return this.mapper.selectOne(record);
    }

    // 根据record查询多个数据，返回list
    public List<T> queryListByWhere(T record) {
        return this.mapper.select(record);
    }

    // 分页查询多个数据列表
    public PageInfo<T> queryPageListByWhere(Integer page, Integer rows, T record) {
        // 设置分页参数
        PageHelper.startPage(page, rows);
        List<T> list = this.mapper.select(record);
        return new PageInfo<T>(list);
    }

    // 更新数据
    public Integer update(T record) {
        return this.mapper.updateByPrimaryKey(record);
    }

    // 有选择的更新数据，选择不为null的字段作为插入字段
    public Integer updateSelective(T record) {
        return this.mapper.updateByPrimaryKeySelective(record);
    }

    // 新增数据
    public Integer save(T record) {
        return this.mapper.insert(record);
    }

    // 有选择的新增，选择不为null的字段作为插入字段
    public Integer saveSelective (T record) {
        return this.mapper.insert(record);
    }
}
