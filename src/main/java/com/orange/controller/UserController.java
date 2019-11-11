package com.orange.controller;

import com.orange.pojo.UserInfo;
import com.orange.service.Imp.UserServiceImp;
import com.orange.uitl.Email;
import com.orange.uitl.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.GeneralSecurityException;
import java.sql.Struct;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("user")
public class UserController {
    private static  String CAPTCHA ;

    @Autowired
    private UserServiceImp userServiceImp;


    //登录
    @RequestMapping("text")
    @ResponseBody
    public UserInfo Text(@RequestBody UserInfo user, HttpServletRequest request) {
        return user;
    }

    //登录
    @RequestMapping("rootlogin")
    @ResponseBody
    public Result rootlogin(@RequestBody UserInfo user, HttpServletRequest request) {
        Result result = new Result();
        UserInfo userinfo = userServiceImp.root(user);
        if (userinfo!=null){
            result.setStatus("0");
            request.getSession().setAttribute("ROOT",userinfo);
            result.setMsg("登陆成功");
        }else{
            result.setStatus("1");
            result.setMsg("登陆失败,账号或者密码错误");
        }
        return result;
    }

    //登录
    @RequestMapping("login")
    @ResponseBody
    public Result selectUser(@RequestBody UserInfo user, HttpServletRequest request) {
        Result result = new Result();
        UserInfo userinfo = userServiceImp.login(user);
        if (userinfo!=null){
            result.setStatus("0");
            request.getSession().setAttribute("user",userinfo);
            result.setMsg("登陆成功");
        }else{
            result.setStatus("1");
            result.setMsg("登陆失败,账号或者密码错误");
        }
        return result;
    }

    //注册
    @RequestMapping("regist")
    @ResponseBody
    public Result regust(@RequestBody UserInfo user, HttpServletRequest request) {
        Result result ;
        if(!user.getCode().equals(CAPTCHA))
            return result =new Result("1","验证码错误");
        if(userServiceImp.regist(user))
            return result =new Result("0","注册成功");
        return  result = new Result("1","注册失败");
    }

    // 忘记密码验证
    @RequestMapping("forget")
    @ResponseBody
    public Result forget(@RequestBody UserInfo user, HttpServletRequest request) {
        Result result ;
        if(user.getCode().equals(CAPTCHA))
            return result =new Result("0","验证成功",user.getUser_email());
        return  result = new Result("1","验证码错误");
    }
    // 修改密码
    @RequestMapping("update_pwd")
    @ResponseBody
    public Result update(@RequestBody UserInfo user, HttpServletRequest request) {
        Result result ;
        System.out.println(user.getUser_pwd());
        System.out.println(user.getUser_email());
        if(userServiceImp.update(user))
            return result =new Result("0","修改密码成功");
        return  result = new Result("1","修改密码失败");
    }
    //发送邮箱验证
    @RequestMapping("check_email")
    @ResponseBody
    public Result check_email(@RequestBody UserInfo userInfo) throws Exception {
        Result result = new Result();
        CAPTCHA =getint();
        if(userInfo.getCode()!=null){
            if (!userServiceImp.check_email(userInfo)){
                if(new Email(userInfo.getUser_email(),CAPTCHA).sendEmail()){
                    result.setStatus("0");
                    result.setMsg("邮箱验证码已发送");
                }else{
                    result.setMsg("邮箱验证码发送失败");
                    result.setStatus("1");
                }
            }else{
                result.setStatus("1");
                result.setMsg("该邮箱尚未注册");
            }
        }else {
            if (userServiceImp.check_email(userInfo)){

                if(new Email(userInfo.getUser_email(),CAPTCHA).sendEmail()){
                    result.setStatus("0");
                    result.setMsg("邮箱验证码已发送");
                }else{
                    result.setMsg("邮箱验证码发送失败");
                    result.setStatus("1");
                }
            }else{
                result.setStatus("1");
                result.setMsg("该邮箱已注册");
            }
        }
        return result;
    }
    //生成随机四位数
    public static String getint(){
        Random r=new Random();
        int tag[]={0,0,0,0,0,0,0,0,0,0};
        String four="";
        int temp=0;
        while(four.length()!=4){
            temp=r.nextInt(10);//随机获取0~9的数字
            if(tag[temp]==0){
                four+=temp;
                tag[temp]=1;
            }
        }
        return four;
    }
}
