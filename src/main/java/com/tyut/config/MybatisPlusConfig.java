package com.tyut.config;

import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @PACKAGE_NAME: agriculture
 * @description: TODO
 * @author: wangchen
 * @create: 2020/2/28 15:19
 **/


@MapperScan("com.tyut.mapper")
@Configuration
public class MybatisPlusConfig {
    /**
     *  分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


    /**
     * 主键生成策略
     * @return
     */
   /* @Bean
    public IKeyGenerator keyGenerator() {
        return new IKeyGenerator() {
            @Override
            public String executeSql(String incrementerName) {
                return "SELECT VPPD." + incrementerName + ".NEXTVAL FROM DUAL";
            }
        };
    }*/
}
