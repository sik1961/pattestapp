package com.sik.pattest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource(value = {
        "classpath:application.properties",
        "classpath:hibernate.properties",
        "file:${app.properties.location}/application.properties",
        "file:${app.properties.location}/hibernate.properties"
}, ignoreResourceNotFound = true)

@EnableTransactionManagement
public class PersistenceJPAConfig{

    @Value("${jdbc.driver.class.name}")
    String jdbcDriverClass;

    @Value("${jdbc.datasource.url}")
    String jdbcDatasourceUrl;

    @Value("${jdbc.datasource.user}")
    String jdbcDatasourceUser;

    @Value("${jdbc.datasource.pass}")
    String jdbcDatasourcePass;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] {"com.sik.pattest.entity"});

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        //em.setJpaProperties(additionalProperties());

        return em;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(jdbcDriverClass);
        dataSource.setUrl(jdbcDatasourceUrl);
        dataSource.setUsername(jdbcDatasourceUser);
        dataSource.setPassword(jdbcDatasourcePass);
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(
            EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
