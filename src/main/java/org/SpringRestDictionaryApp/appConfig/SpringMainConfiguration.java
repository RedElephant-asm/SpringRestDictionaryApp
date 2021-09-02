package org.SpringRestDictionaryApp.appConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Savchenko Kirill
 * @version 1.0
 *
 * Класс является контейнером для конфигурации Spring.
 */
@Configuration
@EnableWebMvc
@ComponentScan("org.SpringRestDictionaryApp")
public class SpringMainConfiguration {
}
