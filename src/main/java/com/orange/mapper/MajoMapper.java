package com.orange.mapper;

import com.orange.pojo.MajorInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MajoMapper {

    @Select("select * from tb_major")
    List<MajorInfo> getMajor();
}
