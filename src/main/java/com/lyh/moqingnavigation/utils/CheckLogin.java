package com.lyh.moqingnavigation.utils;

import cn.hutool.core.util.StrUtil;
import com.lyh.moqingnavigation.controller.result.Code;
import com.lyh.moqingnavigation.controller.result.CodeInfoEnums;
import com.lyh.moqingnavigation.exception.NotLoginException;

import javax.servlet.http.HttpSession;

/**
 * 检查用户是否登录
 *
 * @author :liangyuhang1
 * @className :CheckLogin
 * @date :2023/11/8/17:38
 */
public class CheckLogin {
    /**
     * 检查用户是否已登录
     *
     * @param session HttpSession对象
     * @throws NotLoginException 如果用户未登录
     */
    public static void checkLogin(HttpSession session) {
        String sessionLoginKey = (String) session.getAttribute("session_login_key");
        if (StrUtil.isEmpty(sessionLoginKey)) {
            throw new NotLoginException(Code.NOT_LOGIN, CodeInfoEnums.NOT_LOGIN.getMsg());
        }
    }

}
