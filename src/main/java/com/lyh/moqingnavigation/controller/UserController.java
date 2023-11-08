package com.lyh.moqingnavigation.controller;

import com.lyh.moqingnavigation.controller.result.Code;
import com.lyh.moqingnavigation.controller.result.CodeInfoEnums;
import com.lyh.moqingnavigation.controller.result.Result;
import com.lyh.moqingnavigation.entity.po.User;
import com.lyh.moqingnavigation.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author liangyuhang1
 * @since 2023-11-08 15:55:54
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 分页查询
     *
     * @param user        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public Result queryByPage(User user, PageRequest pageRequest) {
        return null;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result queryById(@PathVariable("id") Integer id) {
        return new Result(Code.GET_OK, "hello", CodeInfoEnums.GET_OK.getMsg());
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public Result add(User user) {
        return null;
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping
    public Result edit(User user) {
        return null;
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result deleteById(Integer id) {
        return null;
    }

}

