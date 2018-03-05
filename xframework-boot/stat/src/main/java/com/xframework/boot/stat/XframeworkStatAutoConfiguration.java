package com.xframework.boot.stat;

import com.xframework.boot.stat.interceptor.LogInterceptor;
import com.xframework.boot.stat.interceptor.SystemLogAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan
public class XframeworkStatAutoConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public SystemLogAspect getSystemLogAspect() {
        SystemLogAspect systemLogAspect = new SystemLogAspect();
        return systemLogAspect;
    }

    @Bean
    public LogInterceptor getLogInterceptor() {
        LogInterceptor logInterceptor = new LogInterceptor();
        return logInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(getLogInterceptor()).addPathPatterns("/**");

        super.addInterceptors(registry);
    }
}
