package com.orange.controller;

import com.orange.pojo.CommentInfo;
import com.orange.service.Imp.CommentServiceImp;
import com.orange.uitl.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("Comment")
public class CommentController {

    @Autowired
    private CommentServiceImp commentServiceImp;

    @RequestMapping("selectComment_list")
    @ResponseBody
    public Result selectComment_list(@RequestBody CommentInfo cid) {
        Result result = new Result();
        List<CommentInfo> list = commentServiceImp.selectComment_list(cid);
        if (list.size() > 0) {
            result.setList(list);
            result.setStatus("success");
        } else {
            result.setStatus("error");
        }
        return result;
    }

    @RequestMapping("deleteComment")
    @ResponseBody
    public Result deleteComment(@RequestBody CommentInfo cid) {
        Result result = new Result();
        boolean b = commentServiceImp.deleteComment(cid);
        if (b)
            result.setStatus("success");
        else
            result.setStatus("error");
        return result;
    }

    @RequestMapping("updateComment_dianzan")
    @ResponseBody
    public Result updateComment_dianzan(@RequestBody CommentInfo cid) {
        Result result = new Result();
        boolean b = commentServiceImp.updateComment_dianzan(cid);
        if (b)
            result.setStatus("success");
        else
            result.setStatus("error");
        return result;
    }

    //回复评论
    @RequestMapping("insertComment_huifu")
    @ResponseBody
    public Result insertComment_huifu(@RequestBody CommentInfo cid) {
        Result result = new Result();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(new Date());
        cid.setC_datetime(date);
        boolean b = commentServiceImp.insertComment_huifu(cid);
        if (b) {
            result.setStatus("success");

        } else {
            result.setStatus("error");
        }

        return result;
    }

}
