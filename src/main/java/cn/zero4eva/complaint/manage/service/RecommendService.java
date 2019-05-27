package cn.zero4eva.complaint.manage.service;

import cn.zero4eva.complaint.manage.mapper.IRecommendCaseInfoMapper;
import cn.zero4eva.complaint.manage.mapper.IRecommendMapper;
import cn.zero4eva.complaint.manage.pojo.RecommendCaseInfo;
import cn.zero4eva.complaint.manage.pojo.RecommendDO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RecommendService
 * @Description 推荐系统
 * @Author Yang
 * @Date 2019-5-9-0009 15:15
 * @Version 1.0
 **/
@Service
public class RecommendService extends BaseService<RecommendDO> {

    @Autowired
    private IRecommendMapper recommendMapper;

    @Autowired
    private IRecommendCaseInfoMapper recommendCaseInfoMapper;

    // TODO 这里应修改为联合查询
    public PageInfo<RecommendDO> listRecommend(Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<RecommendDO> recs = super.queryAll();
        return new PageInfo<>(recs);
    }

    /**
     * 对诉转访风险等级预测不成功的案件进行推荐
     * 先调用推荐系统获取专家姓名，再将其插入推荐系统数据库
     *
     * @param caseId
     * @return
     */
    public boolean predictAndSaveRecommend(String caseId) {
        RecommendCaseInfo recommendCaseInfo = this.recommendCaseInfoMapper.selectByPrimaryKey(caseId);
        String experts = this.predict(recommendCaseInfo);
        // TODO 已修改，需要重新编辑推荐修改逻辑
        return 1 == super.save(new RecommendDO(/*recommendCaseInfo, experts*/));
    }


    // TODO 调用推荐系统，返回专家
    public String predict(RecommendCaseInfo recommendCaseInfo) {
        return "experts";
    }
}
