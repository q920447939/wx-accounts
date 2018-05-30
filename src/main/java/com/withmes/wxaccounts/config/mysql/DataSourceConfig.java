/**
 * @Project: 数据源的配置
 * @Author: liming
 * @Date: 2018年05月18日
 * @Copyright: 2018-2028 www.haokukeji.com Inc. All rights reserved.
 */
package com.withmes.wxaccounts.config.mysql;

/**
 * ClassName: DataSourceConfig
 * @Description: 数据源的配置
 * @author liming
 * @date 2018年05月18日
 */

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


/**
 * 数据源配置
 */
@Configuration
public class DataSourceConfig {

    @Bean(name="dataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource(){
        return new DruidDataSource();
    }

    // 配置事物管理器
    @Bean(name="transactionManager")
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }

}
