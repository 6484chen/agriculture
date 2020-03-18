package com.tyut.config;


import com.tyut.interceptor.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import java.util.Arrays;
import java.util.List;

/**
 * @PACKAGE_NAME: agriculture
 * @description: MVC的配置类
 * @author: wangchen
 * @create: 2020/2/19 11:21
 **/

@Configuration
public class WebMvcConfig {

    /**
     * 实例化拦截器
     * @return
     */
    @Bean
    public HandlerInterceptor getRequestInterceptor() {
        return new RequestInterceptor();
    }


    @Bean
    public org.springframework.web.servlet.config.annotation.WebMvcConfigurer webMvcConfigurer() {
        return new org.springframework.web.servlet.config.annotation.WebMvcConfigurer() {
            // 注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                // 过滤的url
                List<String> patterns = Arrays.asList("/v2/**", "/swagger-ui.html/**", "/swagger-ui/**", "/webjars/**",
                        "/swagger-resources/**", "/login/**", "/foreign/**");
                registry.addInterceptor(getRequestInterceptor()).addPathPatterns("/**").excludePathPatterns(patterns);
            }
        };
    }

}
