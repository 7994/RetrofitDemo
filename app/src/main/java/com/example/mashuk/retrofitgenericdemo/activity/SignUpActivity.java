package com.example.mashuk.retrofitgenericdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mashuk.retrofitgenericdemo.R;
import com.example.mashuk.retrofitgenericdemo.model.RegisterUserModel;
import com.example.mashuk.retrofitgenericdemo.network.RetrofitInstance;
import com.example.mashuk.retrofitgenericdemo.presenter.MainPresenter;
import com.example.mashuk.retrofitgenericdemo.service.MainServiceInterface;
import com.example.mashuk.retrofitgenericdemo.utils.RetrofitListener;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by mashuk on 1/6/18.
 */

public class SignUpActivity extends AppCompatActivity implements RetrofitListener {

    private EditText mEdtUsername;
    private EditText mEdtEmail;
    private EditText mEdtPassword;
    private Button mBtnSignUp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mEdtUsername = (EditText) findViewById(R.id.edtUsername);
        mEdtEmail = (EditText) findViewById(R.id.edtEmail);
        mEdtPassword = (EditText) findViewById(R.id.edtPassword);
        mBtnSignUp = (Button) findViewById(R.id.btnSignUp);

        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callRegisterAPI();
            }
        });
    }

/*    private void callRegisterAPI() {
        RegisterServiceInterface registerServiceInterface = RetrofitInstance.getRetrofitInstance().create(RegisterServiceInterface.class);
        RegisterPresenter registerPresenter = new RegisterPresenter(registerServiceInterface, this, 0);

        Map<String, RequestBody> params = new HashMap<>();
        params.put("username", RequestBody.create(MediaType.parse("text/plain"), mEdtUsername.getText().toString()));
        params.put("password", RequestBody.create(MediaType.parse("text/plain"), mEdtPassword.getText().toString()));
        params.put("email", RequestBody.create(MediaType.parse("text/plain"), mEdtEmail.getText().toString()));

        registerPresenter.registerUser(params);
    }*/

    private void callRegisterAPI() {
        MainServiceInterface mainServiceInterface = RetrofitInstance.getRetrofitInstance().create(MainServiceInterface.class);
        MainPresenter mainPresenter = new MainPresenter(mainServiceInterface, this, 0);

        Map<String, RequestBody> params = new HashMap<>();
        params.put("username", RequestBody.create(MediaType.parse("text/plain"), mEdtUsername.getText().toString()));
        params.put("password", RequestBody.create(MediaType.parse("text/plain"), mEdtPassword.getText().toString()));
        params.put("email", RequestBody.create(MediaType.parse("text/plain"), mEdtEmail.getText().toString()));

        mainPresenter.registerUser(params);
    }

    @Override
    public void handleSuccessResponse(Object response, int type) {
        RegisterUserModel registerUserModel = (RegisterUserModel) response;
        Log.e("handleSuccessResponse", "msg : " + registerUserModel.getMsg());
        Log.e("handleSuccessResponse", "status : " + registerUserModel.getStatus());
        Log.e("handleSuccessResponse", "dataEmail : " + registerUserModel.getData().getEmail());
        Log.e("handleSuccessResponse", "dataUserId : " + registerUserModel.getData().getUserId());
        Log.e("handleSuccessResponse", "dataUsername : " + registerUserModel.getData().getUsername());
    }

    @Override
    public void handleErrorResponse(Object error) {
        Log.e("handleErrorResponse", "error msg : " + error.toString());
    }
}
