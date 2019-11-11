package com.orange.mapper;

import com.orange.pojo.MajorInfo;
import com.orange.pojo.NewsInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NewsMapper {

    //查询所有新闻
    List<NewsInfo> selectNews_list(NewsInfo news);

    //查询热点新闻
    @Select("SELECT news_id,news_title,news_image,news_browse FROM tb_news order by news_browse desc")
    List<NewsInfo> selectNews_heat();

    //查询某一条新闻
    NewsInfo selectNews_user(NewsInfo news);

    //查询某一专业，且不包括正在浏览的新闻
    List<NewsInfo> selectNews_majorList(NewsInfo news);

    //投稿
    @Insert("insert into tb_news (news_title,news_subtitle,news_remarks,news_content,news_date,news_isreprint,major_id,user_id) values (#{news_title},#{news_subtitle},#{news_remarks},#{news_content},#{news_date},#{news_isreprint},#{major_id.major_id},#{user_id.user_id})")
    int contribute(NewsInfo newsInfo);
}
