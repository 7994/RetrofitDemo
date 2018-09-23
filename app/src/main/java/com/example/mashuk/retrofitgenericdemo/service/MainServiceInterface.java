package com.example.mashuk.retrofitgenericdemo.service;

import com.example.mashuk.retrofitgenericdemo.model.LoginUserModel;
import com.example.mashuk.retrofitgenericdemo.model.RegisterUserModel;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

/**
 * Created by mashuk on 4/6/18.
 */

public interface MainServiceInterface {

    @Multipart
    @POST("register")
    Call<RegisterUserModel> registerUser(@PartMap() Map<String, RequestBody> description);

    @Multipart
    @POST("login")
    Call<LoginUserModel> loginUser(@PartMap() Map<String, RequestBody> description);
}
