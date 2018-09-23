package com.example.mashuk.retrofitgenericdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mashuk.retrofitgenericdemo.R;
import com.example.mashuk.retrofitgenericdemo.model.LoginUserModel;
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

public class SignInActivity extends AppCompatActivity implements RetrofitListener{

    private EditText mEdtUsername;
    private EditText mEdtPassword;
    private Button mBtnSignIn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mEdtUsername = (EditText) findViewById(R.id.edtUsername);
        mEdtPassword = (EditText) findViewById(R.id.edtPassword);
        mBtnSignIn = (Button) findViewById(R.id.btnSignIn);

        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callSiginAPI();
            }
        });
    }

    private void callSiginAPI() {
        MainServiceInterface mainServiceInterface = RetrofitInstance.getRetrofitInstance().create(MainServiceInterface.class);
        MainPresenter mainPresenter = new MainPresenter(mainServiceInterface,this,0);

        Map<String, RequestBody> params = new HashMap<>();
        params.put("username", RequestBody.create(MediaType.parse("text/plain"),mEdtUsername.getText().toString()));
        params.put("password", RequestBody.create(MediaType.parse("text/plain"),mEdtPassword.getText().toString()));
        mainPresenter.loginUser(params);
    }

    @Override
    public void handleSuccessResponse(Object response, int type) {
        LoginUserModel loginUserModel = (LoginUserModel) response;
        Log.e("handleSuccessResponse", "msg : " + loginUserModel.getMsg());
        Log.e("handleSuccessResponse", "status : " + loginUserModel.getStatus());
        Log.e("handleSuccessResponse", "userId : " + loginUserModel.getUserId());

        if(loginUserModel.getStatus().equalsIgnoreCase("1")){
            Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void handleErrorResponse(Object error) {
        Log.e("handleErrorResponse", "error msg : " + error.toString());
    }
}
