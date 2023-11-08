package com.lyh.moqingnavigation.controller.result;


import com.lyh.moqingnavigation.exception.BusinessException;
import com.lyh.moqingnavigation.exception.NotLoginException;
import com.lyh.moqingnavigation.exception.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author :liangyuhang1
 * 异常处理器类
 * @className :ProjectExceptionAdvice
 * @date :2023/6/7/22:30
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
    private static final Logger logger = LoggerFactory.getLogger(ProjectExceptionAdvice.class);

    //系统异常
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException e) {
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员, e对象发送给开发人员
        logger.error(e.toString());
        return new Result(e.getCode(), null, e.getMessage());
    }

    //业务异常
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException e) {
        logger.error(e.toString());
        return new Result(e.getCode(), null, e.getMessage());
    }

    // 未登录异常处理
    @ExceptionHandler(NotLoginException.class)
    public Result doNotLoginException(NotLoginException e) {
        logger.error(e.toString());
        return new Result(e.getCode(), null, e.getMessage());
    }

    //其他异常
    @ExceptionHandler(Exception.class)
    public Result doException(Exception e) {
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员, e对象发送给开发人员
        logger.error(e.toString());
        return new Result(Code.SYSTEM_UNKNOW_ERR, null, "系统繁忙, 请稍后再试! --- " + e.getMessage());
    }
}
