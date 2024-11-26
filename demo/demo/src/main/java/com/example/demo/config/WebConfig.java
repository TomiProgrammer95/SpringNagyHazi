package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Minden API-ra
                .allowedOrigins("http://localhost:4200") // Engedélyezett origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Engedélyezett HTTP metódusok
                .allowedHeaders("*") // Engedélyezett fejlécek
                .allowCredentials(true); // Engedélyezi a sütik küldését
    }
}
