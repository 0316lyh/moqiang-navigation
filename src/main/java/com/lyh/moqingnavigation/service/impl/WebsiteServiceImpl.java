package com.lyh.moqingnavigation.service.impl;

import com.lyh.moqingnavigation.entity.po.Website;
import com.lyh.moqingnavigation.dao.WebsiteDao;
import com.lyh.moqingnavigation.service.WebsiteService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Website)表服务实现类
 *
 * @author liangyuhang1
 * @since 2023-11-08 15:55:54
 */
@Service("websiteService")
public class WebsiteServiceImpl implements WebsiteService {
    @Resource
    private WebsiteDao websiteDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Website queryById(Integer id) {
        return this.websiteDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param website 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Website> queryByPage(Website website, PageRequest pageRequest) {
        long total = this.websiteDao.count(website);
        return new PageImpl<>(this.websiteDao.queryAllByLimit(website, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param website 实例对象
     * @return 实例对象
     */
    @Override
    public Website insert(Website website) {
        this.websiteDao.insert(website);
        return website;
    }

    /**
     * 修改数据
     *
     * @param website 实例对象
     * @return 实例对象
     */
    @Override
    public Website update(Website website) {
        this.websiteDao.update(website);
        return this.queryById(website.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.websiteDao.deleteById(id) > 0;
    }
}
