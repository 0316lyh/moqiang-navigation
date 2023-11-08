package com.lyh.moqingnavigation.controller;

import com.lyh.moqingnavigation.controller.result.Code;
import com.lyh.moqingnavigation.controller.result.CodeInfoEnums;
import com.lyh.moqingnavigation.controller.result.Result;
import com.lyh.moqingnavigation.entity.po.Type;
import com.lyh.moqingnavigation.service.TypeService;
import com.lyh.moqingnavigation.utils.CheckLogin;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * (Type)表控制层
 *
 * @author liangyuhang1
 * @since 2023-11-08 15:55:44
 */
@RestController
@RequestMapping("type")
public class TypeController {
    /**
     * 服务对象
     */
    @Resource
    private TypeService typeService;

    /**
     * 分页查询
     *
     * @param type        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public Result queryByPage(HttpSession session) {
        CheckLogin.checkLogin(session);
        System.out.println(111);
        return new Result(200, null, "请求成功");
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
     * @param type 实体
     * @return 新增结果
     */
    @PostMapping
    public Result add(Type type) {
        return null;
    }

    /**
     * 编辑数据
     *
     * @param type 实体
     * @return 编辑结果
     */
    @PutMapping
    public Result edit(Type type) {
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

