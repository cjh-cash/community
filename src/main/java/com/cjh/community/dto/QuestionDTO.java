package com.cjh.community.dto;

import com.cjh.community.model.User;
import lombok.Data;

/**
 * @version v1.0
 * @ProjectName: community
 * @ClassName: QuestionDTO
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CJH
 * @Date: 2020/3/10 14:28
 */
@Data
public class QuestionDTO {
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

    private User user;
}
