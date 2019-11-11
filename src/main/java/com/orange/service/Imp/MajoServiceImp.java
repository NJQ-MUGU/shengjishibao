package com.orange.service.Imp;

import com.orange.mapper.MajoMapper;
import com.orange.pojo.MajorInfo;
import com.orange.service.MajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajoServiceImp implements MajoService {
    @Autowired
    private MajoMapper majoMapper;

    @Override
    public List<MajorInfo> getMajo() {
        return majoMapper.getMajor();
    }
}
