package com.orange.pojo;

public class CommentInfo {

    private int c_id;
    private String c_comment;
    private String c_datetime;
    private int c_dot;
    private NewsInfo news_id;
    private UserInfo user_id;


    public CommentInfo() {
    }

    public CommentInfo(String c_comment, String c_datetime, int c_dot, NewsInfo news_id, UserInfo user_id) {
        this.c_comment = c_comment;
        this.c_datetime = c_datetime;
        this.c_dot = c_dot;
        this.news_id = news_id;
        this.user_id = user_id;
    }

    public CommentInfo(int c_id, String c_comment, String c_datetime, int c_dot, NewsInfo news_id, UserInfo user_id) {
        this.c_id = c_id;
        this.c_comment = c_comment;
        this.c_datetime = c_datetime;
        this.c_dot = c_dot;
        this.news_id = news_id;
        this.user_id = user_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_comment() {
        return c_comment;
    }

    public void setC_comment(String c_comment) {
        this.c_comment = c_comment;
    }

    public String getC_datetime() {
        return c_datetime;
    }

    public void setC_datetime(String c_datetime) {
        this.c_datetime = c_datetime;
    }

    public int getC_dot() {
        return c_dot;
    }

    public void setC_dot(int c_dot) {
        this.c_dot = c_dot;
    }

    public NewsInfo getNews_id() {
        return news_id;
    }

    public void setNews_id(NewsInfo news_id) {
        this.news_id = news_id;
    }

    public UserInfo getUser_id() {
        return user_id;
    }

    public void setUser_id(UserInfo user_id) {
        this.user_id = user_id;
    }
}
