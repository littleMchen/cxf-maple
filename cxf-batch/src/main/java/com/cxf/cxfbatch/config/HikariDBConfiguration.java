package com.cxf.cxfbatch.config;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * description: HikariDBConfiguration <br>
 * date: 2021/11/12 1:02 <br>
 * author: cxf <br>
 * version: 1.0 <br>
 */
@Configuration
public class HikariDBConfiguration {

    private Logger logger = LoggerFactory.getLogger(HikariDBConfiguration.class);

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;


    @Bean
    @Primary  // 被注入的优先级最高
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        logger.info(">>>>>>>> dataSource[url= {} ,username={}]",new Object[]{dbUrl,username});
        dataSource.setJdbcUrl(dbUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

}
