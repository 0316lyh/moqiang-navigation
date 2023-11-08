package com.lyh.moqingnavigation.controller.result;

public enum CodeInfoEnums {

    GET_OK(Code.GET_OK, "查询成功"),
    DELETE_OK(Code.DELETE_OK, "删除成功"),
    UPDATE_OK(Code.UPDATE_OK, "更新成功"),
    SAVE_OK(Code.SAVE_OK, "保存成功"),


    GET_ERR(Code.GET_ERR, "查询失败"),
    DELETE_ERR(Code.DELETE_ERR, "删除失败"),
    UPDATE_ERR(Code.UPDATE_ERR, "更新失败"),
    SAVE_ERR(Code.SAVE_ERR, "保存失败"),


    SYSTEM_ERR(Code.SYSTEM_ERR, "系统异常"),
    SYSTEM_TIMEOUT_ERR(Code.SYSTEM_TIMEOUT_ERR, "系统超时"),
    SYSTEM_UNKNOW_ERR(Code.SYSTEM_UNKNOW_ERR, "系统未知错误"),
    BUSINESS_ERR(Code.BUSINESS_ERR, "系统繁忙"),


    LOGIN_OK(Code.LOGIN_OK, "登陆成功"),
    LOGIN_ERR(Code.LOGIN_ERR, "登陆失败"),
    REGISTER_OK(Code.REGISTER_OK, "注册成功"),
    REGISTER_ERR(Code.REGISTER_ERR, "注册失败"),


    NOT_LOGIN(Code.NOT_LOGIN, "用户未登录，禁止访问");

    private Integer code;
    private String msg;

    CodeInfoEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
