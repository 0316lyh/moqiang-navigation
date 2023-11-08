package com.lyh.moqingnavigation.exception;

/**
 * 系统异常类
 *
 * @author :liangyuhang1
 * @className :SystemException
 * @date :2023/6/7/22:20
 */
public class SystemException extends RuntimeException {
    private int code;

    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public SystemException(int code) {
        this.code = code;
    }

    public SystemException(int code, String message) {
        super(message);
        this.code = code;
    }

    public SystemException(String message) {
        super(message);
        this.message = message;
    }


    public SystemException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

}
