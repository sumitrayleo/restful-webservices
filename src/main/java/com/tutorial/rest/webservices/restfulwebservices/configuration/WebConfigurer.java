package com.tutorial.rest.webservices.restfulwebservices.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.tutorial.rest.webservices.restfulwebservices.interceptor.CustomHeaderInterceptor;

@Configuration
public class WebConfigurer extends WebMvcConfigurationSupport {
    
    @Autowired
    CustomHeaderInterceptor httpHeaderInterceptor;
    
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(httpHeaderInterceptor);
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
