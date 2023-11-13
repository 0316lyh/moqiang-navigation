package com.lyh.moqingnavigation;

import com.lyh.moqingnavigation.constant.Constants;
import com.lyh.moqingnavigation.controller.result.CodeInfoEnums;
import com.lyh.moqingnavigation.dao.UserDao;
import com.lyh.moqingnavigation.service.UserService;
import com.lyh.moqingnavigation.utils.EmailTools;
import com.lyh.moqingnavigation.utils.RedisUtil;
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
    @Autowired
    RedisUtil redisUtil;

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

    @Test
    void test2() {
        String s = redisUtil.get(Constants.REDIS_TOP_NUM_KEY);
        System.out.println(Integer.valueOf(s));
    }
}
