package com.orange.service;

import com.orange.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    //登录
    UserInfo login(UserInfo userInfo);

    UserInfo root(UserInfo userInfo);


    boolean regist(UserInfo userInfo);
    //验证是否已有该邮箱
    boolean  check_email(UserInfo userInfo);

    boolean update(UserInfo userInfo);


}
