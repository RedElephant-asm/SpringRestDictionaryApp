package org.SpringRestDictionaryApp;

import org.SpringRestDictionaryApp.appConfig.SpringMainConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Savchenko Kirill
 * @version 1.0
 *
 * Класс содержит точку входа REST-сервиса.
 */
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationMainContext = new AnnotationConfigApplicationContext(SpringMainConfiguration.class);

        System.out.println("Hello, world!");
    }
}
