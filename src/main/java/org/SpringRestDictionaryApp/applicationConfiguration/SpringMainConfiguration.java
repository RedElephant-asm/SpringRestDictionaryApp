package org.SpringRestDictionaryApp.applicationConfiguration;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Savchenko Kirill
 * @version 1.0
 *
 * Класс является контейнером для конфигурации Spring.
 */
@Configuration
@EnableWebMvc
@ComponentScan("org.SpringRestDictionaryApp")
@PropertySource("classpath:application.properties")
public class SpringMainConfiguration implements WebMvcConfigurer {

}
