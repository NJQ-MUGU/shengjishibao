package com.orange.pojo;

public class NewsInfo {

    private int news_id;
    private String news_title;
    private String news_subtitle;
    private String news_remarks;
    private String news_content;
    private String news_image;
    private String news_video;
    private String news_date;
    private String news_browse;
    private String news_isreprint;
    private MajorInfo major_id;
    private UserInfo user_id;

    public NewsInfo() {
    }

    public NewsInfo(int news_id, String news_title, String news_subtitle, String news_remarks, String news_content, String news_image, String news_video, String news_date, String news_browse, String news_isreprint, MajorInfo major_id, UserInfo user_id) {
        this.news_id = news_id;
        this.news_title = news_title;
        this.news_subtitle = news_subtitle;
        this.news_remarks = news_remarks;
        this.news_content = news_content;
        this.news_image = news_image;
        this.news_video = news_video;
        this.news_date = news_date;
        this.news_browse = news_browse;
        this.news_isreprint = news_isreprint;
        this.major_id = major_id;
        this.user_id = user_id;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_subtitle() {
        return news_subtitle;
    }

    public void setNews_subtitle(String news_subtitle) {
        this.news_subtitle = news_subtitle;
    }

    public String getNews_remarks() {
        return news_remarks;
    }

    public void setNews_remarks(String news_remarks) {
        this.news_remarks = news_remarks;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public String getNews_image() {
        return news_image;
    }

    public void setNews_image(String news_image) {
        this.news_image = news_image;
    }

    public String getNews_video() {
        return news_video;
    }

    public void setNews_video(String news_video) {
        this.news_video = news_video;
    }

    public String getNews_date() {
        return news_date;
    }

    public void setNews_date(String news_date) {
        this.news_date = news_date;
    }

    public String getNews_browse() {
        return news_browse;
    }

    public void setNews_browse(String news_browse) {
        this.news_browse = news_browse;
    }

    public String getNews_isreprint() {
        return news_isreprint;
    }

    public void setNews_isreprint(String news_isreprint) {
        this.news_isreprint = news_isreprint;
    }

    public MajorInfo getMajor_id() {
        return major_id;
    }

    public void setMajor_id(MajorInfo major_id) {
        this.major_id = major_id;
    }

    public UserInfo getUser_id() {
        return user_id;
    }

    public void setUser_id(UserInfo user_id) {
        this.user_id = user_id;
    }
}
