package com.cjh.community.model;

import lombok.Data;

/**
 * @version v1.0
 * @ProjectName: community
 * @ClassName: User
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CJH
 * @Date: 2020/3/4 15:32
 */
@Data
public class User {
    private Long id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;


}
