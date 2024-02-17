package com.develhope.SpringAdvanced0102.configuration;

import com.develhope.SpringAdvanced0102.interceptors.APIMonthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class SpringMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private APIMonthInterceptor apiMonthInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiMonthInterceptor);
    }

}
