package com.example.administrator.demo.Framework.okhttp;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by Administrator on 2017/1/15.
 */
public interface BaseCallback<T> {
    public void onSuccess(T t);
    public void onError(int code);
    public void onFailure(Call call, IOException e);
}
