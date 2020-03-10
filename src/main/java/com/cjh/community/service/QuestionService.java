package com.cjh.community.service;

import com.cjh.community.dto.QuestionDTO;
import com.cjh.community.mapper.QuestionMapper;
import com.cjh.community.mapper.UserMapper;
import com.cjh.community.model.Question;
import com.cjh.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: community
 * @ClassName: QuestionService
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CJH
 * @Date: 2020/3/10 14:33
 */
@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;

    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question:questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            //将question的属性赋值到questionDTO
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
