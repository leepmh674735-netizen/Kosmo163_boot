package com.winter.app.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 설정파일입니다. 객체 생성하세요
public class FileMappingConfig implements WebMvcConfigurer {

    @Value("${app.upload.url}")
    private String url;

    @Value("${app.upload.path}")
    private String base;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler(url) // /files/**
                .addResourceLocations(base) // file:\\D:\\upload\\
        ;

    }

}