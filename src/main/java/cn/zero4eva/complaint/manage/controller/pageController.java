package cn.zero4eva.complaint.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @ClassName: pageController
 * @Description: jsp跳转页面
 * @Author: zero4eva
 * @CreateDate: 2019-5-24-0024 21:39
 */
@Controller
@RequestMapping("/")
public class pageController {

    /**
     * 页面前后缀处理
     *
     * @param pageName
     * @return $pageName$.jsp
     */
//    @RequestMapping(value = "{pageName}", method = RequestMethod.GET)
    @GetMapping("{pageName}")
    public String toPage(@PathVariable("pageName") String pageName) {
        return pageName;
    }

    /**
     * 默认进入index.jsp
     *
     * @return
     */
//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String toPage() {
        return "index";
    }
}
