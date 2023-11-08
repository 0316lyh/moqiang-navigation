package com.lyh.moqingnavigation.controller;

import com.lyh.moqingnavigation.controller.result.Result;
import com.lyh.moqingnavigation.entity.po.Website;
import com.lyh.moqingnavigation.service.WebsiteService;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Website)表控制层
 *
 * @author liangyuhang1
 * @since 2023-11-08 15:55:54
 */
@RestController
@RequestMapping("website")
public class WebsiteController {
    /**
     * 服务对象
     */
    @Resource
    private WebsiteService websiteService;

    /**
     * 分页查询
     *
     * @param website     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public Result queryByPage(Website website, PageRequest pageRequest) {
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
        return null;
    }

    /**
     * 新增数据
     *
     * @param website 实体
     * @return 新增结果
     */
    @PostMapping
    public Result add(Website website) {
        return null;
    }

    /**
     * 编辑数据
     *
     * @param website 实体
     * @return 编辑结果
     */
    @PutMapping
    public Result edit(Website website) {
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

