package com.example.retrofitdemo.bean;

/**
 * @description:
 * @author: zhong
 * @date: 2016/09/18 11:07
 */
public class BaseBean<T> {

    private int flag;
    private String msg;
    private String desc;
    private T result;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
