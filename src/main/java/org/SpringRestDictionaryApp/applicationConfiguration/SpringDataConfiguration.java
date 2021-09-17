package org.SpringRestDictionaryApp.applicationConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = {"org.SpringRestDictionaryApp"})
@EnableTransactionManagement
@PropertySources({
        @PropertySource("classpath:application.properties"),
        @PropertySource("classpath:hibernate/main.properties"),
        @PropertySource("classpath:postgresql/main.properties")
})
public class SpringDataConfiguration {

    /*
         Конфигурация EntityManagerFactory
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean mainEntityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        mainEntityManagerFactory.setDataSource(mainDataSource());
        mainEntityManagerFactory.setPackagesToScan(new String[]{"org.SpringRestDictionaryApp.ORMModels"});
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        mainEntityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        mainEntityManagerFactory.setJpaProperties(additionalProperties());
        return mainEntityManagerFactory;
    }

    /*
        Конфигурация источника данных
     */
    @Bean
    public DataSource mainDataSource(){
        DriverManagerDataSource mainDataSource = new DriverManagerDataSource();

        mainDataSource.setDriverClassName("org.postgresql.Driver");
        mainDataSource.setUsername("dictionarydbmain");
        mainDataSource.setPassword("dictionarymainpassword");
        mainDataSource.setUrl("jdbc:postgresql://localhost:5432/dictionarydb");

        return mainDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslationPostProcessor(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public Properties additionalProperties(){
        Properties properties = new Properties();

        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

        return properties;
    }


}
