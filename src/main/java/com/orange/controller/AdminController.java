package com.orange.controller;

import com.orange.pojo.DepartmentInfo;
import com.orange.pojo.MajorInfo;

import com.orange.pojo.UserInfo;
import com.orange.service.AdminService;
import com.orange.uitl.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    //查询主编
    @RequestMapping("selectEditor")
    @ResponseBody
    public Result selectEditor(@RequestBody UserInfo userInfo, HttpServletRequest request) {

        Result result = new Result();
        List<UserInfo> lis = adminService.selectEditor(userInfo);
        if(lis.size()>0){
            result.setList(lis);
            result.setStatus("0");
            result.setMsg("查询成功！");
        }else{
            result.setStatus("1");
            result.setMsg("查询失败！");
        }
        return  result;
    }

    //删除主编
    @RequestMapping("deleteEditor")
    @ResponseBody
    public Result deleteEditor(@RequestBody UserInfo userInfo, HttpServletRequest request) {
        Result result = new Result();
        int count = adminService.deleteEditor(userInfo);
        if(count == 1){
            result.setStatus("0");
            result.setMsg("删除成功！");
        }else{
            result.setStatus("1");
            result.setMsg("删除失败！");
        }
        return  result;
    }

    //重置主编密码
    @RequestMapping("resetEditorPwd")
    @ResponseBody
    public Result resetEditorPwd(@RequestBody UserInfo userInfo, HttpServletRequest request) {
        Result result = new Result();
        int count = adminService.resetEditorPwd(userInfo);
        if(count == 1){
            result.setStatus("0");
            result.setMsg("重置成功！");
        }else{
            result.setStatus("1");
            result.setMsg("重置失败！");
        }
        return  result;
    }

    //按id查询主编信息
    @RequestMapping("selectByIdEditor")
    @ResponseBody
    public Result selectByIdEditor(@RequestBody UserInfo userInfo, HttpServletRequest request) {
        Result result = new Result();
        UserInfo u = adminService.selectByIdEditor(userInfo);
        if(u!=null){
            result.setList(u);
            result.setStatus("0");
            result.setMsg("查询成功！");
        }else{
            result.setStatus("1");
            result.setMsg("查询失败！");
        }
        return result;
    }
    //修改主编信息
    @RequestMapping("updateEditor")
    @ResponseBody
    public Result updateEditor(@RequestBody UserInfo userInfo, HttpServletRequest request){
        Result result = new Result();
        int count = adminService.updateEditor(userInfo);
        if(count == 1){
            result.setStatus("0");
            result.setMsg("修改成功！");
        }else{
            result.setStatus("1");
            result.setMsg("修改失败！");
        }
        return  result;
    }

    //查询普通用户
    @RequestMapping("selectUser")
    @ResponseBody
    public Result selectUser(@RequestBody UserInfo userInfo, HttpServletRequest request) {
        Result result = new Result();
        List<UserInfo> lis = adminService.selectUser(userInfo);
        if(lis.size()>0){
            result.setList(lis);
            result.setStatus("0");
            result.setMsg("查询用户成功！");
        }else{
            result.setStatus("1");
            result.setMsg("查询用户失败！");
        }
        return  result;
    }


    //删除用户
    @RequestMapping("deleteUser")
    @ResponseBody
    public Result deleteUser(@RequestBody UserInfo userInfo, HttpServletRequest request) {
        Result result = new Result();
        int count = adminService.deleteUser(userInfo);
        if(count == 1){
            result.setStatus("0");
            result.setMsg("删除用户成功！");
        }else{
            result.setStatus("1");
            result.setMsg("删除失败！");
        }
        return  result;
    }

    //重置主编密码
    @RequestMapping("resetUserPwd")
    @ResponseBody
    public Result resetUserPwd(@RequestBody UserInfo userInfo, HttpServletRequest request) {
        Result result = new Result();
        int count = adminService.resetUserPwd(userInfo);
        if(count == 1){
            result.setStatus("0");
            result.setMsg("重置密码成功！");
        }else{
            result.setStatus("1");
            result.setMsg("重置失败！");
        }
        return  result;
    }


    //按id查询用户信息
    @RequestMapping("selectByIdUser")
    @ResponseBody
    public Result selectByIdUser(@RequestBody UserInfo userInfo, HttpServletRequest request) {
        Result result = new Result();
        UserInfo u = adminService.selectByIdUser(userInfo);
        if(u!=null){
            result.setList(u);
            result.setStatus("0");
            result.setMsg("查询用户成功！");
        }else{
            result.setStatus("1");
            result.setMsg("查询失败！");
        }
        return result;
    }


    //修改用户信息
    @RequestMapping("updateUser")
    @ResponseBody
    public Result updateUser(@RequestBody UserInfo userInfo, HttpServletRequest request){
        Result result = new Result();
        int count = adminService.updateUser(userInfo);
        if(count == 1){
            result.setStatus("0");
            result.setMsg("修改用户成功！");
        }else{
            result.setStatus("1");
            result.setMsg("修改失败！");
        }
        return  result;
    }

    //添加用户
    @RequestMapping("insertUser")
    @ResponseBody
    public Result insertUser(@RequestBody UserInfo userInfo, HttpServletRequest request){
        Result result = new Result();
        int count = adminService.insertUser(userInfo);
        if(count == 1){
            result.setStatus("0");
            result.setMsg("添加成功！");
        }else{
            result.setStatus("1");
            result.setMsg("修改失败！");
        }
        return  result;
    }


    //按院系id查询专业
    @RequestMapping("selectMajor")
    @ResponseBody
    public Result selectMajor(@RequestBody DepartmentInfo departmentInfo, HttpServletRequest request) {
        Result result = new Result();
        List<MajorInfo> lis = adminService.selectMajor(departmentInfo);
        if(lis.size()>0){
            result.setList(lis);
            result.setStatus("0");
            result.setMsg("查询专业成功！");
        }else{
            result.setStatus("1");
            result.setMsg("查询失败！");
        }
        return result;
    }
}
