package com.orange.service.Imp;

import com.orange.mapper.MajoMapper;
import com.orange.mapper.NewsMapper;
import com.orange.pojo.MajorInfo;
import com.orange.pojo.NewsInfo;
import com.orange.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsServiceimp  implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<NewsInfo> selectNews_list(NewsInfo news) {
        return newsMapper.selectNews_list(news);
    }

    @Override
    public List<NewsInfo> selectNews_heat() {
        return newsMapper.selectNews_heat();
    }

    @Override
    public NewsInfo selectNews_user(NewsInfo news) {
        return newsMapper.selectNews_user(news);
    }

    @Override
    public List<NewsInfo> selectNews_majorList(NewsInfo news) {
        return newsMapper.selectNews_majorList(news);
    }


    @Override
    public boolean contribute(NewsInfo news) {
        if(newsMapper.contribute(news)>0)
        return true;
        return  false;
    }
}
