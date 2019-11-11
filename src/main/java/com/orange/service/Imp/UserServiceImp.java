package com.orange.service.Imp;

import com.orange.mapper.UserMapper;
import com.orange.pojo.UserInfo;
import com.orange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    //登陆
    public UserInfo login(UserInfo userInfo) {
        return userMapper.Login(userInfo);
    }

    @Override
    public UserInfo root(UserInfo userInfo) {
        return userMapper.root(userInfo);
    }

    @Override
    public boolean regist(UserInfo userInfo) {
        if (userMapper.regist(userInfo) >0)
            return true;
        return false;
    }


    @Override
    public boolean check_email(UserInfo userInfo) {
        if (userMapper.check_email(userInfo) == null)
            return true;
        return false;
    }

    @Override
    public boolean update(UserInfo userInfo) {
        if (userMapper.update(userInfo) >0)
            return true;
        return false;
    }
}
