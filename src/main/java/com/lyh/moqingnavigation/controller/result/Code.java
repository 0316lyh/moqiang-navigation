package com.lyh.moqingnavigation.controller.result;

/**
 * @author :liangyuhang1
 * @className :Code
 * @date :2023/6/6/21:52
 */
public class Code {
    public static final Integer SAVE_OK = 20011;
    public static final Integer DELETE_OK = 20021;
    public static final Integer UPDATE_OK = 20031;
    public static final Integer GET_OK = 20041;

    public static final Integer SAVE_ERR = 20010;
    public static final Integer DELETE_ERR = 20020;
    public static final Integer UPDATE_ERR = 20030;
    public static final Integer GET_ERR = 20040;


    public static final Integer SYSTEM_ERR = 50001;
    public static final Integer SYSTEM_TIMEOUT_ERR = 50002;
    public static final Integer SYSTEM_UNKNOW_ERR = 59999;
    public static final Integer BUSINESS_ERR = 60002;

    // 登录注册相关
    public static final Integer LOGIN_OK = 20051;
    public static final Integer LOGIN_ERR = 20050;
    public static final Integer REGISTER_OK = 20061;
    public static final Integer REGISTER_ERR = 20060;

    public static final Integer NOT_LOGIN = 40001;
}
