package com.lyh.moqingnavigation.service.impl;

import cn.hutool.core.util.StrUtil;
import com.lyh.moqingnavigation.constant.Constants;
import com.lyh.moqingnavigation.entity.po.Website;
import com.lyh.moqingnavigation.dao.WebsiteDao;
import com.lyh.moqingnavigation.service.WebsiteService;
import com.lyh.moqingnavigation.utils.RedisUtil;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private RedisUtil redisUtil;

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
     * @param website     筛选条件
     * @param pageRequest 分页对象
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

    /**
     * 根据typeId查询网站
     *
     * @param typeId
     * @return
     */
    @Override
    public List<Website> selectByTypeId(Integer typeId) {
        return websiteDao.selectByTypeId(typeId);
    }

    /**
     * 查询推荐网站
     *
     * @return List<Website>
     */
    @Override
    public List<Website> selectRecommended() {
        return websiteDao.selectRecommended();
    }

    /**
     * 根据一级分类查网站
     *
     * @param topType
     * @return
     */
    @Override
    public List<Website> getByTopType(String topType) {
        return websiteDao.getByTopType(topType);
    }

    /**
     * 增加点赞数
     *
     * @param id
     * @return
     */
    @Override
    public Integer addLiked(Integer id) {
        return websiteDao.addLiked(id);
    }

    /**
     * 获取点赞前num的网站列表
     *
     * @return 前几个最常访问的网站列表
     */
    @Override
    public List<Website> getTopByLiked() {
        String topNum = redisUtil.get(Constants.REDIS_TOP_NUM_KEY);
        if (!StrUtil.isBlank(topNum)) {
            return websiteDao.getTopByLiked(Integer.valueOf(topNum));
        } else {
            // 缓存中没有，设置topNum = 5,
            redisUtil.set(Constants.REDIS_TOP_NUM_KEY, "5");
            return websiteDao.getTopByLiked(5);
        }
    }
    
}
