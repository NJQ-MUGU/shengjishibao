package com.orange.controller;

import com.orange.pojo.MajorInfo;
import com.orange.service.Imp.MajoServiceImp;
import com.orange.service.Imp.UserServiceImp;
import com.orange.uitl.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("major")
public class MajorController {
    @Autowired
    private MajoServiceImp majoServiceImp;

    @RequestMapping("getmajor")
    @ResponseBody
    private Result getMajor(){
        List<MajorInfo> m = majoServiceImp.getMajo();
        if(m!=null)
        return new Result("0","查询成功",m)  ;
        return new Result("1","查询失败")  ;

    };

}
