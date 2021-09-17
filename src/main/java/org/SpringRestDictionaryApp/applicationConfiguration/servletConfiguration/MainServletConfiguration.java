package org.SpringRestDictionaryApp.applicationConfiguration.servletConfiguration;

import org.SpringRestDictionaryApp.applicationConfiguration.SpringMainConfiguration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class DispatcherServletConfiguration implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(SpringMainConfiguration.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("mainServlet", new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/main");
    }
}
