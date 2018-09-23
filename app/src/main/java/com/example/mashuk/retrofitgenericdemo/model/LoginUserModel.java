package com.example.mashuk.retrofitgenericdemo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mashuk on 4/6/18.
 */

public class LoginUserModel {

    @SerializedName("msg")
    private String msg;
    @SerializedName("status")
    private String status;
    @SerializedName("user_id")
    private String userId;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
