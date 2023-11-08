package com.lyh.moqingnavigation;

import com.lyh.moqingnavigation.controller.result.CodeInfoEnums;
import com.lyh.moqingnavigation.dao.UserDao;
import com.lyh.moqingnavigation.service.UserService;
import com.lyh.moqingnavigation.utils.EmailTools;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MoqingNavigationApplicationTests {
    @Resource
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        System.out.println(CodeInfoEnums.SAVE_OK.getCode());
        System.out.println(CodeInfoEnums.SAVE_OK.getMsg());
    }

    @Test
    void test1() {
        System.out.println(userService.queryById(1));
        System.out.println(userDao.queryById(1));
    }

}
