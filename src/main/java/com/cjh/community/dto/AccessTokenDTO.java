package com.cjh.community.dto;

import lombok.Data;

/**
 * @version v1.0
 * @ProjectName: community
 * @ClassName: AccessTokenDTO
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CJH
 * @Date: 2020/3/3 11:31
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;


}
