package com.cjh.community.mapper;

import com.cjh.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    @Insert("insert into user (name,account_Id,token,gmt_create,gmt_modified,avatar_url) " +
            "values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insertUser(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Long id);
}
