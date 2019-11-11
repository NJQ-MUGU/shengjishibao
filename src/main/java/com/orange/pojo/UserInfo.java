package com.orange.pojo;

public class UserInfo {

    private int user_id;
    private String user_account;
    private String user_pwd;
    private String user_name;
    private String user_email;
    private String user_sex;
    private String user_birthday;
    private String user_signature;

    public UserInfo(int user_id, String user_account, String user_pwd, String user_name, String user_email, String user_sex, String user_birthday, String user_signature, String user_image, String code, StateInfo state_id, MajorInfo major_id) {
        this.user_id = user_id;
        this.user_account = user_account;
        this.user_pwd = user_pwd;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_sex = user_sex;
        this.user_birthday = user_birthday;
        this.user_signature = user_signature;
        this.user_image = user_image;
        this.code = code;
        this.state_id = state_id;
        this.major_id = major_id;
    }

    public String getUser_image() {
        return user_image;
    }

    public void setUser_image(String user_image) {
        this.user_image = user_image;
    }

    private String user_image;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserInfo(int user_id, String user_account, String user_pwd, String user_name, String user_email, String user_sex, String user_birthday, String user_signature, String code, StateInfo state_id, MajorInfo major_id) {
        this.user_id = user_id;
        this.user_account = user_account;
        this.user_pwd = user_pwd;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_sex = user_sex;
        this.user_birthday = user_birthday;
        this.user_signature = user_signature;
        this.code = code;
        this.state_id = state_id;
        this.major_id = major_id;
    }

    private StateInfo state_id;
    private MajorInfo major_id;

    public UserInfo() {
    }

    public UserInfo(String user_account, String user_pwd, String user_name, String user_email, String user_sex, String user_birthday, String user_signature, StateInfo state_id, MajorInfo major_id) {
        this.user_account = user_account;
        this.user_pwd = user_pwd;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_sex = user_sex;
        this.user_birthday = user_birthday;
        this.user_signature = user_signature;
        this.state_id = state_id;
        this.major_id = major_id;
    }

    public UserInfo(int user_id, String user_account, String user_pwd, String user_name, String user_email, String user_sex, String user_birthday, String user_signature, StateInfo state_id, MajorInfo major_id) {
        this.user_id = user_id;
        this.user_account = user_account;
        this.user_pwd = user_pwd;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_sex = user_sex;
        this.user_birthday = user_birthday;
        this.user_signature = user_signature;
        this.state_id = state_id;
        this.major_id = major_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(String user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_signature() {
        return user_signature;
    }

    public void setUser_signature(String user_signature) {
        this.user_signature = user_signature;
    }

    public StateInfo getState_id() {
        return state_id;
    }

    public void setState_id(StateInfo state_id) {
        this.state_id = state_id;
    }

    public MajorInfo getMajor_id() {
        return major_id;
    }

    public void setMajor_id(MajorInfo major_id) {
        this.major_id = major_id;
    }
}
