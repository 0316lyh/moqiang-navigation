package com.lyh.moqingnavigation.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyh.moqingnavigation.entity.po.Website;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Website)表数据库访问层
 *
 * @author liangyuhang1
 * @since 2023-11-08 15:55:54
 */
@Mapper
public interface WebsiteDao extends BaseMapper<Website> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Website queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param website  查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Website> queryAllByLimit(Website website, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param website 查询条件
     * @return 总行数
     */
    long count(Website website);

    /**
     * 新增数据
     *
     * @param website 实例对象
     * @return 影响行数
     */
    int insert(Website website);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Website> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Website> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Website> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Website> entities);

    /**
     * 修改数据
     *
     * @param website 实例对象
     * @return 影响行数
     */
    int update(Website website);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

