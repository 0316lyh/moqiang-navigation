package com.lyh.moqingnavigation.exception;

/**
 * 业务异常类
 *
 * @author :liangyuhang1
 * @className :SystemException
 * @date :2023/6/7/22:20
 */
public class NotLoginException extends RuntimeException {
    private int code;

    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public NotLoginException(int code) {
        this.code = code;
    }

    public NotLoginException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public NotLoginException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotLoginException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

}
