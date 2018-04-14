//package org.itstep.config;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.hibernate.jpa.HibernatePersistenceProvider;
//import org.itstep.ApplicationRunner;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.annotation.TransactionManagementConfigurer;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//
//@Configuration
//@EnableJpaRepositories("org.itstep.dao")
//@EnableTransactionManagement
//public class DataBaseConfig implements TransactionManagementConfigurer {
//
//    @Value("${dataSource.driverClassName}")
//    private String driver;
//    
//    @Value("${dataSource.url}")
//    private String url;
//    
//    @Value("${dataSource.username}")
//    private String username;
//    
//    @Value("${dataSource.password}")
//    private String password;
//    
//    @Value("${hibernate.dialect}")
//    private String dialect;
//    
//    @Value("${hibernate.hbm2ddl.auto}")
//    private String hbm2ddlAuto;
//
//
//    @Bean
//    public DataSource configureDataSource() {
//        HikariConfig config = new HikariConfig();
//        config.setDriverClassName(driver);
//        config.setJdbcUrl(url);
//        config.setUsername(username);
//        config.setPassword(password);
//
//        return new HikariDataSource(config);
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean configureEntityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(configureDataSource());
//        entityManagerFactoryBean.setPackagesToScan("org.itstep.model");
//        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//
//        Properties jpaProperties = new Properties();
//        jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, dialect);
//        jpaProperties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, hbm2ddlAuto);
//        jpaProperties.put("persistenceProvider", new HibernatePersistenceProvider());
//        entityManagerFactoryBean.setJpaProperties(jpaProperties);
//
//        return entityManagerFactoryBean;
//    }
//
//    @Bean
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        JpaTransactionManager jtp =  new JpaTransactionManager();
//        jtp.setDataSource(configureDataSource());
//        return jtp;
//    }
//
//}