package com.lyh.moqingnavigation.service;

import com.lyh.moqingnavigation.entity.po.Website;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Website)表服务接口
 *
 * @author liangyuhang1
 * @since 2023-11-08 15:55:54
 */
public interface WebsiteService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Website queryById(Integer id);

    /**
     * 分页查询
     *
     * @param website     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Website> queryByPage(Website website, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param website 实例对象
     * @return 实例对象
     */
    Website insert(Website website);

    /**
     * 修改数据
     *
     * @param website 实例对象
     * @return 实例对象
     */
    Website update(Website website);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 根据typeId查询网站
     *
     * @param typeId
     * @return
     */
    List<Website> selectByTypeId(Integer typeId);

    /**
     * 查询推荐网站
     *
     * @return List<Website>
     */
    List<Website> selectRecommended();

    /**
     * 根据一级分类查网站
     *
     * @return
     */
    List<Website> getByTopType(String topType);

    /**
     * 增加点赞数
     *
     * @param id
     * @return
     */
    Integer addLiked(Integer id);

    /**
     * 获取点赞前num的网站列表
     *
     * @param num
     * @return 前几个最常访问的网站列表
     */
    List<Website> getTopByLiked();
}
