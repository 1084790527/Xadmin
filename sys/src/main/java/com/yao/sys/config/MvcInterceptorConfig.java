package com.yao.sys.config;

import com.yao.sys.interceptor.SysInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import java.io.File;
import java.util.List;

/**
 * @author : 妖妖
 * @date : 15:07 2020/7/9
 */
@Configuration
@Slf4j
public class MvcInterceptorConfig extends WebMvcConfigurationSupport {


    @Value("${spring.resources.static-locations}")
    private String locations;

    @Autowired
    private SysInterceptor sysInterceptor;

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置静态文件
        registry.addResourceHandler("/assets/**").addResourceLocations(locations);
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(sysInterceptor)
        .addPathPatterns("/**")
        .excludePathPatterns("/assets")
        .excludePathPatterns("/assets/**")
        .excludePathPatterns("/demo/**")    //测试页面
        .excludePathPatterns("/demo")    //测试页面
        .excludePathPatterns("/login")
        .excludePathPatterns("/login/**")
        .excludePathPatterns("/error/404")
        .excludePathPatterns("/404")
        .excludePathPatterns("/error/500")
        .excludePathPatterns("/500")
        ;
        super.addInterceptors(registry);
    }

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/index");
        registry.addViewController("/demo").setViewName("/demo/index");
    }

}
