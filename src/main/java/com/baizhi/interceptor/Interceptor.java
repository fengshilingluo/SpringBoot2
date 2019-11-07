package com.baizhi.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class Interceptor extends WebMvcConfigurerAdapter {

    @Autowired
    private MyInterceptor myInterceptor;//获取自定义的拦截器

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //把自定义的拦截器注册到注册中心中         //拦截哪些路径     //排除哪些路径
        registry.addInterceptor(myInterceptor).addPathPatterns("/user/**").excludePathPatterns("/user/u1");
    }
}
