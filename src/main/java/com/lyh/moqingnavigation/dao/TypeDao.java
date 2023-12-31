package com.lyh.moqingnavigation.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyh.moqingnavigation.entity.po.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Type)表数据库访问层
 *
 * @author liangyuhang1
 * @since 2023-11-08 15:55:46
 */
@Mapper
public interface TypeDao extends BaseMapper<Type> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Type queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param type     查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Type> queryAllByLimit(Type type, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param type 查询条件
     * @return 总行数
     */
    long count(Type type);

    /**
     * 新增数据
     *
     * @param type 实例对象
     * @return 影响行数
     */
    int insert(Type type);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Type> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Type> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Type> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Type> entities);

    /**
     * 修改数据
     *
     * @param type 实例对象
     * @return 影响行数
     */
    int update(Type type);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

