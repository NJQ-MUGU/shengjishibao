package com.orange.service.Imp;

import com.orange.mapper.AdminMapper;
import com.orange.pojo.DepartmentInfo;
import com.orange.pojo.MajorInfo;
import com.orange.pojo.UserInfo;
import com.orange.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    //查询主编
    @Override
    public List<UserInfo> selectEditor(UserInfo userInfo) {
       return adminMapper.selectEditor(userInfo);
    }

    //删除主编
    @Override
    public int deleteEditor(UserInfo userInfo) {
        int count = adminMapper.deleteEditor(userInfo);
        return count;
    }

    //重置主编密码
    @Override
    public int resetEditorPwd(UserInfo userInfo) {
        int count = adminMapper.resetEditorPwd(userInfo);
        return count;
    }

    //按id查询主编信息
    @Override
    public UserInfo selectByIdEditor(UserInfo userInfo) {
        return adminMapper.selectByIdEditor(userInfo);
    }

    //修改主编信息
    @Override
    public int updateEditor(UserInfo userInfo) {
        int count = adminMapper.updateEditor(userInfo);
        return count;
    }

    //查询普通用户
    @Override
    public List<UserInfo> selectUser(UserInfo userInfo) {
        return adminMapper.selectUser(userInfo);
    }

    //删除用户
    @Override
    public int deleteUser(UserInfo userInfo) {
        int count = adminMapper.deleteUser(userInfo);
        return count;
    }

    //重置用户密码
    @Override
    public int resetUserPwd(UserInfo userInfo) {
        int count = adminMapper.resetUserPwd(userInfo);
        return count;
    }

    //按id查询用户信息
    @Override
    public UserInfo selectByIdUser(UserInfo userInfo) {
        return adminMapper.selectByIdUser(userInfo);
    }

    //修改用户信息
    @Override
    public int updateUser(UserInfo userInfo) {
        int count = adminMapper.updateUser(userInfo);
        return count;
    }

    //添加用户信息
    @Override
    public int insertUser(UserInfo userInfo) {
        int count  = adminMapper.insertUser(userInfo);
        return count;
    }

    @Override
    public List<MajorInfo> selectMajor(DepartmentInfo departmentInfo) {
        return adminMapper.selectMajor(departmentInfo);
    }
}
