package com.lyh.moqingnavigation.service;

import com.lyh.moqingnavigation.entity.po.Website;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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
     * @param website 筛选条件
     * @param pageRequest      分页对象
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

}
