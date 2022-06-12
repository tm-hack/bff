package com.example.bff.config;

import com.example.bff.app.web.ServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ComponentScan("com.example.bff.app.web")
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    ServiceProperties properties;

    @Bean
    public RestOperations restOperations(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.rootUri(properties.getDns()).build();
    }

}
