package com.orange.mapper;

import com.orange.pojo.CommentInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CommentMapper {

    //查询所有
    List<CommentInfo> selectComment_list(CommentInfo cid);

    //删除评论
    @Delete("delete from tb_comment where c_id = #{c_id}")
    boolean deleteComment(CommentInfo cid);

    //点赞
    @Update("update tb_comment set c_dot = c_dot + 1 where c_id = #{c_id}")
    boolean updateComment_dianzan(CommentInfo cid);

    //回复
    @Insert("insert into tb_comment(c_comment,c_datetime,news_id,user_id) value(#{c_comment},#{c_datetime},#{news_id.news_id},#{user_id.user_id})")
    boolean insertComment_huifu(CommentInfo cid);
}
