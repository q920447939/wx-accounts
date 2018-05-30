/**
 * @Project: mybatis的配置
 * @Author: liming
 * @Date: 2018年05月18日
 * @Copyright: 2018-2028 www.haokukeji.com Inc. All rights reserved.
 */
package com.withmes.wxaccounts.config.mysql;

/**
 * ClassName: MybatisPlusConfig
 * @Description: mybatis的配置
 * @author liming
 * @date 2018年05月18日
 */

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//扫描dao或者是Mapper接口
@MapperScan("com.withmes.plan.mapper*")
public class MybatisPlusConfig {
    /**
     * mybatis-plus 分页插件
     */

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }

}