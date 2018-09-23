package com.example.mashuk.retrofitgenericdemo.presenter;

import android.util.Log;

import com.example.mashuk.retrofitgenericdemo.model.LoginUserModel;
import com.example.mashuk.retrofitgenericdemo.model.RegisterUserModel;
import com.example.mashuk.retrofitgenericdemo.service.MainServiceInterface;
import com.example.mashuk.retrofitgenericdemo.utils.RetrofitListener;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mashuk on 4/6/18.
 */

public class MainPresenter implements MainServiceInterface {

    private MainServiceInterface mainServiceInterface;
    private RetrofitListener registerView;
    private int type;

    public MainPresenter(MainServiceInterface mainServiceInterface, RetrofitListener registerView, int type) {
        this.mainServiceInterface = mainServiceInterface;
        this.registerView = registerView;
        this.type = type;
    }

    @Override
    public Call<RegisterUserModel> registerUser(Map<String, RequestBody> description) {
        Call<RegisterUserModel> registerUserModelCall = mainServiceInterface.registerUser(description);
        registerUserModelCall.enqueue(new Callback<RegisterUserModel>() {
            @Override
            public void onResponse(Call<RegisterUserModel> call, Response<RegisterUserModel> response) {
                if (response != null) {
                    Log.e("RegisterPresenter", "response : " + response);
                    registerView.handleSuccessResponse(response.body(), type);
                }
            }

            @Override
            public void onFailure(Call<RegisterUserModel> call, Throwable exception) {
                Log.e("RegisterPresenter", "Exception : " + exception.getMessage());
                registerView.handleErrorResponse(exception.getMessage());
            }
        });
        return null;
    }

    @Override
    public Call<LoginUserModel> loginUser(Map<String, RequestBody> description) {
        Call<LoginUserModel> loginUserModelCall = mainServiceInterface.loginUser(description);
        loginUserModelCall.enqueue(new Callback<LoginUserModel>() {
            @Override
            public void onResponse(Call<LoginUserModel> call, Response<LoginUserModel> response) {
                if(response!=null){
                    Log.e("RegisterPresenter", "response : " + response);
                    registerView.handleSuccessResponse(response.body(), type);
                }
            }

            @Override
            public void onFailure(Call<LoginUserModel> call, Throwable exception) {
                Log.e("RegisterPresenter", "Exception : " + exception.getMessage());
                registerView.handleErrorResponse(exception.getMessage());
            }
        });
        return null;
    }
}
