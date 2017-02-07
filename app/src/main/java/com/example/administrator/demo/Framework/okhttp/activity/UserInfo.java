package com.example.administrator.demo.Framework.okhttp.activity;

/**
 * Created by Administrator on 2017/1/13.
 */
public class UserInfo {
    private UserData data;
    private String error;
    private String messager;

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessager() {
        return messager;
    }

    public void setMessager(String messager) {
        this.messager = messager;
    }
}
