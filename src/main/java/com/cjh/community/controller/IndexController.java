package com.cjh.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @version v1.0
 * @ProjectName: community
 * @ClassName: HelloController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CJH
 * @Date: 2020/3/2 13:04
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String hello(){
        return "index";
    }
}
