package com.vehiclesSystem.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


@Configuration
@ComponentScan(basePackages = "com.vehiclesSystem")
@PropertySource("classpath:app.properties")
public class Config {

}
