package com.cjh.community.controller;

import com.cjh.community.dto.QuestionDTO;
import com.cjh.community.mapper.QuestionMapper;
import com.cjh.community.mapper.UserMapper;
import com.cjh.community.model.Question;
import com.cjh.community.model.User;
import com.cjh.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String hello(HttpServletRequest request,
                        Model model){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null&&cookies.length!=0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }

        List<QuestionDTO> questionList = questionService.list();
        model.addAttribute("questions",questionList);
        return "index";
    }
}
