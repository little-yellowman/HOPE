package com.meyou.ssss.config;

import com.meyou.ssss.common.handler.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfiguration {

    @Bean
    public WebMvcConfigurer myConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/img/**")
                        .addResourceLocations("file:F:\\数学与计算机科学学院\\计算机科学与技术-2017计算机科学与技术\\");
            }

            //跨域请求
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")//设置允许跨域的路径
                        .allowCredentials(true)//是否允许证书，例如可以使用cookie
                        .maxAge(3600)
                        .allowedMethods("*")//设置允许的方法
                        .allowedOrigins("*");//设置允许跨域请求的的域名
            }

            //token拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(tokenInterceptor())
                        .addPathPatterns("/**")
                        .excludePathPatterns("/img/**");
            }
        };
    }

    @Bean
    public TokenInterceptor tokenInterceptor(){
        return new TokenInterceptor();
    }
}
