package com.orange.pojo;

public class StateInfo {

    private int state_id;
    private String state_type;

    public StateInfo() {
    }

    public StateInfo(int state_id, String state_type) {
        this.state_id = state_id;
        this.state_type = state_type;
    }

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }

    public String getState_type() {
        return state_type;
    }

    public void setState_type(String state_type) {
        this.state_type = state_type;
    }
}
