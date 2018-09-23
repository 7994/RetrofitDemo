package com.example.mashuk.retrofitgenericdemo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mashuk on 4/6/18.
 */

public class RegisterUserModel {

    @SerializedName("msg")
    private String msg;
    @SerializedName("status")
    private String status;
    @SerializedName("data")
    private Data data;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {

        @SerializedName("user_id")
        private String userId;
        @SerializedName("username")
        private String username;
        @SerializedName("email")
        private String email;

        public Data(String userId, String username, String email) {
            this.userId = userId;
            this.username = username;
            this.email = email;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

}
