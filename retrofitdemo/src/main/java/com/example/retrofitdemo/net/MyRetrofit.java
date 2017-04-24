package com.example.retrofitdemo.net;

import com.example.retrofitdemo.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Damon on 2017/4/20.
 * Description :
 */

public class MyRetrofit {
    private static IService iService = null;
    public static IService getiService(){
        if (iService == null) {
            OkHttpClient httpClient = new OkHttpClient();
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                httpClient = new OkHttpClient.Builder().addInterceptor(logging).build();
            }
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();//使用 gson coverter，统一日期请求格式
            Retrofit mRetrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(httpClient)
                    .baseUrl(Keys.IP)
                    .build();
            iService = mRetrofit.create(IService.class);
            return iService;
        }
        return iService;
    }
}
