package com.example.delivery_burgers.config;

import javax.persistence.EntityManagerFactory;

import liquibase.integration.spring.SpringLiquibase;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

//@Configuration
//@PropertySource("classpath:application.properties")
//@EnableJpaRepositories("com.example.delivery_burgers.repository")
//@EnableTransactionManagement
public class DataConfig {

    @Bean
    public DataSource ds(@Value("${driver}") String driver,
                         @Value("${url}") String url,
                         @Value("${username}") String username,
                         @Value("${password}") String password) {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

//    @Bean
//    public JdbcTemplate jdbc(DataSource ds) {
//        return new JdbcTemplate(ds);
//    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(@Value("${hibernate.dialect}") String dialect,
                                                                                         @Value("${entity}") String entity,
                                                                                         DataSource ds) {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setPackagesToScan(entity);
        factory.setDataSource(ds);
        Properties cfg = new Properties();
        cfg.setProperty("hibernate.dialect", dialect);
        factory.setJpaProperties(cfg);
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    public SpringLiquibase liquibase(DataSource ds) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:db/liquibase-changeLog.xml");
        liquibase.setDataSource(ds);
        return liquibase;
    }
}
