package com.example.mashuk.retrofitgenericdemo.presenter;

import android.util.Log;

import com.example.mashuk.retrofitgenericdemo.model.RegisterUserModel;
import com.example.mashuk.retrofitgenericdemo.service.RegisterServiceInterface;
import com.example.mashuk.retrofitgenericdemo.utils.RetrofitListener;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mashuk on 4/6/18.
 */

public class RegisterPresenter implements RegisterServiceInterface {

    private RegisterServiceInterface registerServiceInterface;
    private RetrofitListener registerView;
    private int type;

    public RegisterPresenter(RegisterServiceInterface registerServiceInterface, RetrofitListener registerView, int type) {
        this.registerServiceInterface = registerServiceInterface;
        this.registerView = registerView;
        this.type = type;
    }

    @Override
    public Call<RegisterUserModel> registerUser(Map<String, RequestBody> description) {
        Call<RegisterUserModel> registerUserModelCall = registerServiceInterface.registerUser(description);
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
}
