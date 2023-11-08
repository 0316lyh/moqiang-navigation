package com.lyh.moqingnavigation.entity.po;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.io.Serializable;

/**
 * (Website)实体类
 *
 * @author liangyuhang1
 * @since 2023-11-08 15:55:54
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Website implements Serializable {
    private static final long serialVersionUID = 741488852457114482L;
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 网站名
     */
    private String name;
    /**
     * 网站类型id
     */
    private Integer typeId;
    /**
     * 网站图标
     */
    private String icon;
    /**
     * 网站url
     */
    private String url;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}

