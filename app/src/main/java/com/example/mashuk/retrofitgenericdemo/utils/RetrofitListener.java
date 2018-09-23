package com.example.mashuk.retrofitgenericdemo.utils;

/**
 * Created by mashuk on 4/6/18.
 */

public interface RetrofitListener<T> {

    void handleSuccessResponse(T response, int type);
    void handleErrorResponse(T error);
}
