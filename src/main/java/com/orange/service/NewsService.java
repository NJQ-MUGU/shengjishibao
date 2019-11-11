package com.orange.service;

import com.orange.pojo.MajorInfo;
import com.orange.pojo.NewsInfo;

import java.util.List;

public interface NewsService {

    List<NewsInfo> selectNews_list(NewsInfo news);

    List<NewsInfo> selectNews_heat();

    NewsInfo selectNews_user(NewsInfo news);

    List<NewsInfo> selectNews_majorList(NewsInfo news);


    boolean contribute(NewsInfo news);
}
