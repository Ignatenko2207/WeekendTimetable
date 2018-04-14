package org.itstep.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories("org.itstep.dao")
@EnableTransactionManagement
@EnableAsync
@EntityScan("org.itstep.model")
@ConfigurationProperties
public class DBConfig extends HikariConfig {

	@Value("${dataSource.driverClassName}")
    private String driver;
    
    @Value("${dataSource.url}")
    private String url;
    
    @Value("${dataSource.username}")
    private String username;
    
    @Value("${dataSource.password}")
    private String password;
    
    @Value("${hibernate.dialect}")
    private String dialect;
    
    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;


	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(configureDataSource());
		em.setPackagesToScan(new String[] { "org.itstep" });
		em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		em.setJpaProperties(additionalProperties());
		return em;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", hbm2ddlAuto);
		return properties;
	}

	@Bean
  public DataSource configureDataSource() {
      HikariConfig config = new HikariConfig();
      config.setDriverClassName(driver);
      config.setJdbcUrl(url);
      config.setUsername(username);
      config.setPassword(password);

      return new HikariDataSource(config);
  }
//        Properties dataSourceProperties = new Properties();
//        dataSourceProperties.put("user", username);
//        dataSourceProperties.put("password", password);
//        dataSourceProperties.put("url", url);
//        Properties configProperties = new Properties();
//        configProperties.put("dataSourceClassName", dataSourceClassName);
//        configProperties.put("dataSourceProperties", dataSourceProperties);
//        HikariConfig hikariConfig = new HikariConfig(configProperties);
//        return new HikariDataSource(hikariConfig);
    }