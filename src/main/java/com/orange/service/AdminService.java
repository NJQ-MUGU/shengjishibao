package com.orange.service;

import com.orange.pojo.DepartmentInfo;
import com.orange.pojo.MajorInfo;
import com.orange.pojo.UserInfo;

import java.util.List;

public interface AdminService {
    //查询主编
    public List<UserInfo> selectEditor(UserInfo userInfo);

    //删除主编
    public int deleteEditor(UserInfo userInfo);

    //重置主编密码
    public int resetEditorPwd(UserInfo userInfo);

    //按id查询主编信息
    public UserInfo selectByIdEditor(UserInfo userInfo);

    //修改主编信息
    public int updateEditor(UserInfo userInfo);

    //查询普通用户
    public List<UserInfo> selectUser(UserInfo userInfo);

    //删除用户
    public int deleteUser(UserInfo userInfo);

    //重置用户密码
    public int resetUserPwd(UserInfo userInfo);

    //按id查询用户信息
    public UserInfo selectByIdUser(UserInfo userInfo);

    //修改用户信息
    public int updateUser(UserInfo userInfo);

    //添加用户信息
    public int insertUser(UserInfo userInfo);

    //根据院系id查询专业
    public List<MajorInfo> selectMajor(DepartmentInfo departmentInfo);
}
