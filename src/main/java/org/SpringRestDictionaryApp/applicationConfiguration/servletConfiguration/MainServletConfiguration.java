package org.SpringRestDictionaryApp.applicationConfiguration.servletConfiguration;

import org.SpringRestDictionaryApp.applicationConfiguration.SpringMainConfiguration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class MainServletConfiguration implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        /*
            Создание главного контекста сервлетов.
         */
        AnnotationConfigWebApplicationContext mainContext = new AnnotationConfigWebApplicationContext();

        /*
            Регистрация конфигурации Spring 5 на основе java-класса.
         */
        mainContext.register(SpringMainConfiguration.class);

        /*
            Добавление слушателя в контекст.
         */
        servletContext.addListener(new ContextLoaderListener(mainContext));

        /*
            Переключение на контекст нового сервлета
         */
        mainContext.setServletContext(servletContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("mainServlet", new DispatcherServlet(mainContext));

        /*
            Указание адресного пространства, прослушиваемого сервлетом.
         */
        servlet.addMapping("/mainApp/*");

        /*
            Приоритет загрузки сервлета.
         */
        servlet.setLoadOnStartup(1);
    }
}
