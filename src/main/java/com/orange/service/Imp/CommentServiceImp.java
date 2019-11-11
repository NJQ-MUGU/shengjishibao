package com.orange.service.Imp;

import com.orange.mapper.CommentMapper;
import com.orange.pojo.CommentInfo;
import com.orange.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImp implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<CommentInfo> selectComment_list(CommentInfo cid) {
        return commentMapper.selectComment_list(cid);
    }

    @Override
    public boolean deleteComment(CommentInfo cid) {
        return commentMapper.deleteComment(cid);
    }

    @Override
    public boolean updateComment_dianzan(CommentInfo cid) {
        return commentMapper.updateComment_dianzan(cid);
    }

    @Override
    public boolean insertComment_huifu(CommentInfo cid) {
        return commentMapper.insertComment_huifu(cid);
    }
}
