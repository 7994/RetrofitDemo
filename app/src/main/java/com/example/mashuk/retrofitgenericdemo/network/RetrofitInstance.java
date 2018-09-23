package com.example.mashuk.retrofitgenericdemo.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mashuk on 4/6/18.
 */

public class RetrofitInstance {
    private static Retrofit retrofit;
//    private static final String BASE_URL = "http://navjacinth9.000webhostapp.com/json/";
    private static final String BASE_URL = "http://www.kenilshah.com/mysocial/api/api/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
