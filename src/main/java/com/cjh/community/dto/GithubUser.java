package com.cjh.community.dto;

import lombok.Data;

/**
 * @version v1.0
 * @ProjectName: community
 * @ClassName: GithubUser
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CJH
 * @Date: 2020/3/3 12:16
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;

}
