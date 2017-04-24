package com.example.retrofitdemo.bean;

/**
 * Created by Damon on 2017/4/20.
 * Description :
 */

public class LoginBean {

    /**
     * flag : 0
     * msg : f53925bc-8ec5-4721-ab92-551de46addfb
     */

    private String flag;
    private String msg;
    private String loginKeyCode;

    public String getLoginKeyCode() {
        return loginKeyCode;
    }

    public void setLoginKeyCode(String loginKeyCode) {
        this.loginKeyCode = loginKeyCode;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "flag='" + flag + '\'' +
                ", msg='" + msg + '\'' +
                ", loginKeyCode='" + loginKeyCode + '\'' +
                '}';
    }
}
