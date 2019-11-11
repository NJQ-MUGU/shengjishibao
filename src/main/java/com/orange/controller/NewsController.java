package com.orange.controller;

import com.orange.pojo.NewsInfo;
import com.orange.pojo.UserInfo;
import com.orange.service.Imp.NewsServiceimp;
import com.orange.service.Imp.UserServiceImp;
import com.orange.uitl.Result;
import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("news")

public class NewsController {

    @Autowired
    private NewsServiceimp newsServiceimp;


    //登录
    @RequestMapping("contribute")
    @ResponseBody
    public Result Text(@RequestBody NewsInfo news) {
        Result r;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        java.util.Date d = new java.util.Date();
        news.setNews_date(sdf.format(d));

        System.out.println(news.getUser_id().getUser_id());
        if(newsServiceimp.contribute(news))
        return r = new Result("0","投稿成功");
        return r = new Result("1","投稿失败");
    }
    //查询所有新闻
    @RequestMapping("selectNews_list")
    @ResponseBody
    public Result selectNews_list(@RequestBody NewsInfo news){
        Result result = new Result();
        List<NewsInfo> list = newsServiceimp.selectNews_list(news);

        if (list!= null){
            result.setList(list);
            result.setStatus("success");
        }else {
            result.setStatus("error");
        }
        return result;
    }
    //查询热度新闻
    @RequestMapping("selectNews_heat")
    @ResponseBody
    public Result selectNews_heat(){
        Result result = new Result();
        List<NewsInfo> list = newsServiceimp.selectNews_heat();
        if (list.size() > 0){
            result.setList(list);
            result.setStatus("success");
        }else {
            result.setStatus("error");
        }
        return  result;
    }

    //查询某一条新闻
    @RequestMapping("selectNews_user")
    @ResponseBody
    public Result selectNews_user(@RequestBody NewsInfo news){
        Result result = new Result();
        NewsInfo newsInfo = newsServiceimp.selectNews_user(news);
        System.out.println(newsInfo+" "+"qwertyu");
        if (newsInfo != null){
            result.setList(newsInfo);

            result.setStatus("success");
        }else {
            result.setStatus("error");
        }
        return result;
    }

    @RequestMapping("selectNews_majorList")
    @ResponseBody
    public Result selectNews_majorList(@RequestBody NewsInfo news){
        Result result = new Result();
        List<NewsInfo> list = newsServiceimp.selectNews_majorList(news);
        if (list.size() > 0){
            result.setList(list);
            result.setStatus("success");
        }else {
            result.setStatus("error");
        }

        return result;
    }

}