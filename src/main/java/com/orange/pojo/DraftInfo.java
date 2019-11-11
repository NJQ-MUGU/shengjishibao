package com.orange.pojo;

public class DraftInfo {

    private int draft_id;
    private String draft_title;
    private String draft_content;
    private String draft_image;
    private String draft_voide;
    private String draft_date;
    private String draft_state;
    private NewsInfo news_id;
    private UserInfo user_id;

    public DraftInfo() {
    }

    public DraftInfo(String draft_title, String draft_content, String draft_image, String draft_voide, String draft_date, String draft_state, NewsInfo news_id, UserInfo user_id) {
        this.draft_title = draft_title;
        this.draft_content = draft_content;
        this.draft_image = draft_image;
        this.draft_voide = draft_voide;
        this.draft_date = draft_date;
        this.draft_state = draft_state;
        this.news_id = news_id;
        this.user_id = user_id;
    }

    public DraftInfo(int draft_id, String draft_title, String draft_content, String draft_image, String draft_voide, String draft_date, String draft_state, NewsInfo news_id, UserInfo user_id) {
        this.draft_id = draft_id;
        this.draft_title = draft_title;
        this.draft_content = draft_content;
        this.draft_image = draft_image;
        this.draft_voide = draft_voide;
        this.draft_date = draft_date;
        this.draft_state = draft_state;
        this.news_id = news_id;
        this.user_id = user_id;
    }

    public int getDraft_id() {
        return draft_id;
    }

    public void setDraft_id(int draft_id) {
        this.draft_id = draft_id;
    }

    public String getDraft_title() {
        return draft_title;
    }

    public void setDraft_title(String draft_title) {
        this.draft_title = draft_title;
    }

    public String getDraft_content() {
        return draft_content;
    }

    public void setDraft_content(String draft_content) {
        this.draft_content = draft_content;
    }

    public String getDraft_image() {
        return draft_image;
    }

    public void setDraft_image(String draft_image) {
        this.draft_image = draft_image;
    }

    public String getDraft_voide() {
        return draft_voide;
    }

    public void setDraft_voide(String draft_voide) {
        this.draft_voide = draft_voide;
    }

    public String getDraft_date() {
        return draft_date;
    }

    public void setDraft_date(String draft_date) {
        this.draft_date = draft_date;
    }

    public String getDraft_state() {
        return draft_state;
    }

    public void setDraft_state(String draft_state) {
        this.draft_state = draft_state;
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
