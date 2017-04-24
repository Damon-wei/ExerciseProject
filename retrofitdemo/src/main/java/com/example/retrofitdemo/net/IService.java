package com.example.retrofitdemo.net;

import com.example.retrofitdemo.bean.BaseBean;
import com.example.retrofitdemo.bean.CurrentUserInfoBean;
import com.example.retrofitdemo.bean.LoginBean;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Damon on 2017/4/20.
 * Description :
 */

public interface IService {
    @FormUrlEncoded
    @POST(Keys.appLogin)
    Observable<LoginBean> appLogin(@FieldMap Map<String, String> user);

    @GET(Keys.getCurrentUserInfo)
    Observable<BaseBean<CurrentUserInfoBean>> getCurrentUserInfo(@Query("loginKeyCode") String loginKeyCode, @Query("userName") String userName);
}
