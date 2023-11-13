package com.lyh.moqingnavigation.entity.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * (Website)实体类
 *
 * @author liangyuhang1
 * @since 2023-11-08 15:55:54
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WebsiteDTO implements Serializable {
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
     * 网站描述
     */
    private String content;
    /**
     * 网站url
     */
    private String url;

    /**
     * 是否被推荐，0否，1是
     */
    private Integer recommended;

    /**
     * 所属一级分类
     */
    private String topType;

    /**
     * 被点在次数
     */
    private Integer liked;

    public Integer getLiked() {
        return liked;
    }

    public void setLiked(Integer liked) {
        this.liked = liked;
    }

    public String getTopType() {
        return topType;
    }

    public void setTopType(String topType) {
        this.topType = topType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRecommended() {
        return recommended;
    }

    public void setRecommended(Integer recommended) {
        this.recommended = recommended;
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

}

