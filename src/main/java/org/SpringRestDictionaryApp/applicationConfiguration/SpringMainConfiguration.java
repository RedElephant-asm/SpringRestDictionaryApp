package org.SpringRestDictionaryApp.appConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author Savchenko Kirill
 * @version 1.0
 *
 * Класс является контейнером для конфигурации Spring.
 */
@Configuration
@EnableWebMvc
@ComponentScan("org.SpringRestDictionaryApp")
public class SpringMainConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer {

    /**
     * @param servletContext
     * @throws ServletException
     *
     *
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        /**
         * Настройка DispatcherServlet - центрального сервлета, который отправляет запросы контроллерам и предлагает другие функции, облегчающие
         * разработку веб-приложений. DispatcherServlet является выражением шаблона проектирования "Front Controller".
         */
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet());

        /**
         * Предположительно приоритет загрузки сервлета.
         */
        registration.setLoadOnStartup(1);

        /**
         * Разметка запросов, которые должен будет обрабатывать DispatcherServlet, с помощью Url-адресации.
         */
        registration.addMapping("/testUrl/*");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}
