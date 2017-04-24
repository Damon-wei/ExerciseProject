package com.example.retrofitdemo.net;

/**
 * Created by Damon on 2017/4/20.
 * Description :
 */

public class Keys {
    public static final String BaseUrl = "http://moa.itongban.com";//正式环境
    public static final String IP = BaseUrl+"/xztb-api/";

    public static final String appLogin= "platformAction.do?method=appLogin"; //登录
    public static final String register= "app/login/user/add.do";//注册
    public static final String getIdentifycode= "app/login/get/identifycode.do";//验证码获取
    public static final String authIdentifycode= "app/login/auth/identifycode.do";//验证码认证
    public static final String getCurrentUserInfo = "app/user/queryUserInfoByUserId.do"; //通过手机号获取用户信息
    public static final String getContacts = "app/addressBook/queryAllAddressBookInfo.do";//获取用户的通讯录
    public static final String getAppsList = "app/orgfun/list.do";//获取应用列表
}
