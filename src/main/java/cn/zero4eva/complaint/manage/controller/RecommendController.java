package cn.zero4eva.complaint.manage.controller;

import cn.zero4eva.complaint.manage.model.pojo.RecommendVO;
import cn.zero4eva.complaint.manage.model.pojo.WebPageResult;
import cn.zero4eva.complaint.manage.service.LawsuitPredictResultService;
import com.github.pagehelper.PageInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName RecommendController
 * @Description 查询推荐信息
 * @Author Yang
 * @Date 2019-5-9-0009 15:15
 * @Version 1.0
 **/

@Controller
@RequestMapping(value = "/recommend")
public class RecommendController {

    private final LawsuitPredictResultService lawsuitPredictResultService;

    public RecommendController(LawsuitPredictResultService lawsuitPredictResultService) {
        this.lawsuitPredictResultService = lawsuitPredictResultService;
    }

    /**
     * 查询所有推荐信息并返回指定列表
     *
     * @param pageNumber
     * @param pageSize
     * @return 返回分页后的推荐数据列表
     */
    @GetMapping("/list")
    public ResponseEntity<WebPageResult> queryRecommendList(
            @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {

        try {
            PageInfo<RecommendVO> pageInfo = this.lawsuitPredictResultService.listRecommend(pageNumber, pageSize);
            WebPageResult wpr = new WebPageResult(pageInfo.getTotal(), pageInfo.getList());
            return ResponseEntity.ok(wpr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
