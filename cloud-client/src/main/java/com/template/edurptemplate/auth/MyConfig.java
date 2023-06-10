package com.template.edurptemplate.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ProjectName: edurp-template
 * @Package: com.template.edurptemplate.common.config
 * @ClassName: MyConfig
 * @Author: 作者名字
 * @Description:
 * @Version: 1.0
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> collect = Stream.of("/static/**", "/templates/**","/admin/login","/image/**").collect(Collectors.toList());
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(collect);// /**匹配所有的路径

    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("file:/Users/作者名字/zhangq/money/edurp-template/src/main/resources/img/");
    }
}
