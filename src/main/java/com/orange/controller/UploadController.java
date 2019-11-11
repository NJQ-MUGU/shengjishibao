package com.orange.controller;

import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
@Controller
public class UploadController {
    //上传文件
    @ResponseBody
    @RequestMapping(value = "/uploadFile", produces = "application/json", method = RequestMethod.POST)

    public String uploadFile(HttpServletRequest request, @Param("file") MultipartFile file) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        java.util.Date d = new java.util.Date();
        String res = sdf.format(d);
        //服务器上使用
        // String rootPath =request.getServletContext().getRealPath("/resource/uploads/");//target的目录
        //本地使用
        File f=new File("D:/update");

        if(!f.exists())

        {

            try {

                f.createNewFile();

            } catch (IOException e) {

                // TODO Auto-generated catch block

                e.printStackTrace();

            }

        }
        String rootPath ="/update/";
        //原文件名称
        String originalFilename = file.getOriginalFilename();

        //新的文件名称

        String newFileName = res+originalFilename.substring(originalFilename.lastIndexOf("."));

        //创建年月文件夹

        Calendar date = Calendar.getInstance();

        File dateDirs = new File(date.get(Calendar.YEAR)

                + File.separator + (date.get(Calendar.MONTH)+1));

        //新文件

        File newFile = new File(rootPath+File.separator+dateDirs+File.separator+newFileName);

        //判断目标文件所在的目录是否存在

        if(!newFile.getParentFile().exists()) {

            //如果目标文件所在的目录不存在，则创建父目录

            newFile.getParentFile().mkdirs();

        }

        System.out.println(newFile);

        //将内存中的数据写入磁盘

        file.transferTo(newFile);

        //完整的url


        String fileUrl =  "/uploads/"+date.get(Calendar.YEAR)+ "/"+(date.get(Calendar.MONTH)+1)+ "/"


                +newFileName; //以 Map 方式 创建JSON，最终返回给 前台


        Map<String,Object> map = new HashMap<String,Object>();


        Map<String,Object> map2 = new HashMap<String,Object>();


        map.put("code",0);//0表示成功，1失败




        map.put("msg","上传成功");//提示消息

        map.put("data",map2);

        map2.put("src",fileUrl);//图片url

        map2.put("title",newFileName);//图片名称，这个会显示在输入框里

        String result = new JSONObject(map).toString();

        return result;




    }
}
