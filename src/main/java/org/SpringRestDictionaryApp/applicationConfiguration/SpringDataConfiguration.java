package org.SpringRestDictionaryApp.applicationConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
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
        @PropertySource("classpath:jpa/main.properties")
})
public class SpringDataConfiguration {

    @Autowired
    private Environment environment;

    /*
         Конфигурация EntityManagerFactory
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean mainEntityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        mainEntityManagerFactory.setDataSource(mainDataSource());
        mainEntityManagerFactory.setPackagesToScan(new String[]{environment.getProperty("ORM.entities.directory")});
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

        mainDataSource.setDriverClassName(environment.getProperty("jpaDriverClassName"));
        mainDataSource.setUsername(environment.getProperty("jpaUsername"));
        mainDataSource.setPassword(environment.getProperty("jpaPassword"));
        mainDataSource.setUrl(environment.getProperty("jpaUrl"));

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

        properties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
        properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));

        return properties;
    }


}
