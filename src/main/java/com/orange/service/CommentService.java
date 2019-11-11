package com.orange.service;

import com.orange.pojo.CommentInfo;

import java.util.List;

public interface CommentService {

    List<CommentInfo> selectComment_list(CommentInfo cid);

    boolean deleteComment(CommentInfo cid);

    boolean updateComment_dianzan(CommentInfo cid);

    boolean insertComment_huifu(CommentInfo cid);
}
