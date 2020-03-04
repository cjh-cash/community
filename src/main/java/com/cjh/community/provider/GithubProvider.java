package com.cjh.community.provider;

import com.alibaba.fastjson.JSON;
import com.cjh.community.dto.AccessTokenDTO;
import com.cjh.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @version v1.0
 * @ProjectName: community
 * @ClassName: GithubProvider
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CJH
 * @Date: 2020/3/3 11:31
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            System.out.println(token);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @Description 通过accessToken获取User信息
     * @Author  ChenJianHong
     * @Date   2020/3/3 12:24
     * @Param
     * @Return
     * @Exception
     */
    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        /**
         * 注意github授权登录改为
         *  .url("https://api.github.com/user")
         *  .header("Authorization","token "+accessToken)
         *  .build();
         */
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization","token "+accessToken)
                .build();
        try{
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            System.out.println("String"+string);
            GithubUser githubUser = JSON.parseObject(string,GithubUser.class);
            return githubUser;
        }catch (IOException e){}
        return null;
    }
}
