package com.lyh.moqingnavigation.controller;

import com.lyh.moqingnavigation.controller.result.Code;
import com.lyh.moqingnavigation.controller.result.CodeInfoEnums;
import com.lyh.moqingnavigation.controller.result.Result;
import com.lyh.moqingnavigation.entity.dto.WebsiteDTO;
import com.lyh.moqingnavigation.entity.po.Website;
import com.lyh.moqingnavigation.service.WebsiteService;
import com.lyh.moqingnavigation.utils.ObjectConverter;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Website)表控制层
 *
 * @author liangyuhang1
 * @since 2023-11-08 15:55:54
 */
@RestController
@RequestMapping("website")
public class WebsiteController {
    private static final Logger logger = LoggerFactory.getLogger(WebsiteController.class);


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

    /**
     * 根据typeId查询网站
     *
     * @param typeId
     * @return
     */
    @GetMapping("/{typeId}")
    public Result selectByTypeId(@PathVariable Integer typeId) {
        List<Website> websites = websiteService.selectByTypeId(typeId);
        return new Result(Code.GET_OK, websites, CodeInfoEnums.GET_OK.getMsg());
    }

    /**
     * 法查询推荐网站列表(首页展示的网站)
     *
     * @return 首页展示的网站
     */
    @GetMapping("/recommended")
    public Result selectRecommended() {
        List<Website> websites = websiteService.selectRecommended();
        return new Result(Code.GET_OK, websites, CodeInfoEnums.GET_OK.getMsg());
    }


    /**
     * 通过顶级类型获取网站列表
     *
     * @param topType 顶级类型
     * @return 网站列表结果对象
     */
    @GetMapping("/getbytoptype/{topType}")
    public Result getByTopType(@PathVariable("topType") String topType) {
        List<Website> websites = websiteService.getByTopType(topType);
        return new Result(Code.GET_OK, websites, CodeInfoEnums.GET_OK.getMsg());
    }

    /**
     * 添加点赞
     *
     * @param id 网站id
     * @return 点赞数
     */
    @PutMapping("/addLiked/{id}")
    public Result addLiked(@PathVariable("id") Integer id) {
        Integer integer = websiteService.addLiked(id);
        return new Result(Code.UPDATE_OK, integer, CodeInfoEnums.UPDATE_OK.getMsg());
    }

    /**
     * 获取点赞前num的网站列表
     *
     * @param num
     * @return 前几个最常访问的网站列表
     */
    @GetMapping("/getTopByLiked")
    public Result getTopByLiked() {
        List<Website> websites = websiteService.getTopByLiked();
        return new Result(Code.GET_OK, websites, CodeInfoEnums.GET_OK.getMsg());
    }
}

