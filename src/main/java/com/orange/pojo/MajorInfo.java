package com.orange.pojo;

public class MajorInfo {

    private int major_id;
    private String major_name;
    private DepartmentInfo dpm_id;


    public MajorInfo() {
    }

    public MajorInfo(String major_name, DepartmentInfo dpm_id) {
        this.major_name = major_name;
        this.dpm_id = dpm_id;
    }

    public MajorInfo(int major_id, String major_name, DepartmentInfo dpm_id) {
        this.major_id = major_id;
        this.major_name = major_name;
        this.dpm_id = dpm_id;
    }

    public int getMajor_id() {
        return major_id;
    }

    public void setMajor_id(int major_id) {
        this.major_id = major_id;
    }

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }

    public DepartmentInfo getDpm_id() {
        return dpm_id;
    }

    public void setDpm_id(DepartmentInfo dpm_id) {
        this.dpm_id = dpm_id;
    }
}
