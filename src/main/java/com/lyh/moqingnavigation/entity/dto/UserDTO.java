package com.lyh.moqingnavigation.entity.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * (User)实体类
 *
 * @author liangyuhang1
 * @since 2023-11-08 15:55:54
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 322051830103380936L;
    /**
     * id,自增
     */
    private Integer id;
    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

