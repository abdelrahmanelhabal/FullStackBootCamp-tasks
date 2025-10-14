package main.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Configuration
@Component
@ComponentScan(basePackages = "main.com.myApp")
@PropertySource("classpath:app.properties")
public class UserConfig {

}
