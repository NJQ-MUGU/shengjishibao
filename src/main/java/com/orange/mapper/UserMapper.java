package com.orange.mapper;

import com.orange.pojo.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    //登录
    @Select("select * from tb_user where user_email = #{user_email} and user_pwd = #{user_pwd}")
    UserInfo Login(UserInfo user);

    //登录
    @Select("select * from tb_user where user_account = #{user_account} and user_pwd = #{user_pwd} " +
            "and state_id in (select  state_id  from tb_state where 。 = 'admin') ")
    UserInfo root(UserInfo user);

    //注册
    @Insert("insert tb_user(user_name,user_email, user_pwd)  values (#{user_name},#{user_email},#{user_pwd}) ")
    int regist(UserInfo userInfo);

    //邮箱验证
    @Select("select * from tb_user where user_email = #{user_email}")
    UserInfo check_email(UserInfo userInfo);

    //修改密码
    @Update("update tb_user set user_pwd =#{user_pwd} where user_email = #{user_email}")
    int update(UserInfo u);
}
