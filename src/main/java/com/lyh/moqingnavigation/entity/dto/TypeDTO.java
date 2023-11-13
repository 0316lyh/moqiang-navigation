package com.lyh.moqingnavigation.entity.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * (Type)实体类
 *
 * @author liangyuhang1
 * @since 2023-11-08 15:55:46
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TypeDTO implements Serializable {
    private static final long serialVersionUID = -74208396960129404L;
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 类型名称
     */
    private String typeName;
    /**
     * 图标
     */
    private String icon;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}

