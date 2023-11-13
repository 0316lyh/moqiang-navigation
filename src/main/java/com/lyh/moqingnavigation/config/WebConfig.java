package com.lyh.moqingnavigation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author :liangyuhang1
 * @className :WebConfig
 * @date :2023/11/10/00:05
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 为指定的CorsRegistry添加CORS映射规则
        registry.addMapping("/**") // 设置CORS映射的路径为根路径及其所有子路径
                .allowedOrigins("*") // 允许所有来源的请求
                .allowedHeaders("*") // 允许所有请求头
                .allowedMethods("GET", "POST", "DELETE", "PUT"); // 允许GET、POST、DELETE和PUT方法的请求
    }
    
}
