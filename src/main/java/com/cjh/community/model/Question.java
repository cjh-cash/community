package com.cjh.community.model;

import lombok.Data;

/**
 * @version v1.0
 * @ProjectName: community
 * @ClassName: Question
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CJH
 * @Date: 2020/3/6 10:50
 */
@Data
public class Question {
    private Long id;
    private String title;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
    private String description;


}
