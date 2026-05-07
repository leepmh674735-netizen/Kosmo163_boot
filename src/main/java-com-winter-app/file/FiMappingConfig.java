package com.winter.yubin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servler.config.annotation.RespurceHandlerRegistry;
import org.springframework.web.servler.config.annotation.WebMvcConfigurer;

@Configuration
public class FileMappingConfig implements WebMvcConfigurer {

@Value("${yubin.upload.url}")
private String urlPath;

@Value("${yubin.upload.path}")
private String resourcePath;

@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
registry.addResourceHandler(urlPath)
.addResourceLocations(resourcePath);
}
}