package com.orange.mapper;

import com.orange.pojo.DepartmentInfo;
import com.orange.pojo.MajorInfo;
import com.orange.pojo.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminMapper {

    //查询主编
    public List<UserInfo> selectEditor(UserInfo userInfo);

    //删除主编
    @Delete("delete from tb_user where user_id =#{user_id}")
    public int deleteEditor(UserInfo userInfo);

    //重置主编密码
    @Update("update tb_user set user_pwd='000000' where user_id = #{user_id}")
    public int resetEditorPwd(UserInfo userInfo);

    //按id查询主编信息
    public UserInfo selectByIdEditor(UserInfo userInfo);

    //修改主编信息
    public int updateEditor(UserInfo userInfo);

    //查询普通用户
    public List<UserInfo> selectUser(UserInfo userInfo);

    //删除用户
    @Delete("delete from tb_user where user_id =#{user_id}")
    public int deleteUser(UserInfo userInfo);

    //重置用户密码
    @Update("update tb_user set user_pwd='888888' where user_id = #{user_id}")
    public int resetUserPwd(UserInfo userInfo);

    //按id查询用户信息
    public UserInfo selectByIdUser(UserInfo userInfo);

    //修改用户信息
    public int updateUser(UserInfo userInfo);

    //添加用户信息
    public int insertUser(UserInfo userInfo);

    //根据院系id查询专业
    @Select("select * from tb_major where dpm_id =#{dpm_id}")
    public List<MajorInfo> selectMajor(DepartmentInfo departmentInfo);

}
