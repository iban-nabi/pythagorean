package com.jie.pythagorean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        // enable access from live server hosted website or file://
                        .allowedOrigins("http://127.0.0.1:5500", "http://localhost:5500", "null")
                        .allowedMethods("GET")
                        .allowCredentials(true);
            }
        };
    }
}
