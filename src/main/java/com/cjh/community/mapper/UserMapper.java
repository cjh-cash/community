package com.cjh.community.mapper;

import com.cjh.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @version v1.0
 * @ProjectName: community
 * @ClassName: UserMapper
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CJH
 * @Date: 2020/3/4 15:31
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user (name,account_Id,token,gmt_create,gmt_modified) " +
            "values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insertUser(User user);

}
