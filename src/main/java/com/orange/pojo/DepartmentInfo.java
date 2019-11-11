package com.orange.pojo;

public class DepartmentInfo {

    private int dpm_id;
    private String dpm_name;

    public DepartmentInfo() {
    }

    public DepartmentInfo(int dpm_id, String dpm_name) {
        this.dpm_id = dpm_id;
        this.dpm_name = dpm_name;
    }

    public int getDpm_id() {
        return dpm_id;
    }

    public void setDpm_id(int dpm_id) {
        this.dpm_id = dpm_id;
    }

    public String getDpm_name() {
        return dpm_name;
    }

    public void setDpm_name(String dpm_name) {
        this.dpm_name = dpm_name;
    }
}
