package com.kude.stu.kudestu.stu.entity;

public class LoginMsg {
    private int code;  //登录状态码，1为成功，0为失败
    private User result;

    public LoginMsg() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public User getResult() {
        return result;
    }

    public void setResult(User result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "LoginMsg{" +
                "code=" + code +
                ", result=" + result +
                '}';
    }
}
