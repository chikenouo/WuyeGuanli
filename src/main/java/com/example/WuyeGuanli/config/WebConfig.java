package com.example.WuyeGuanli.config;

import com.example.WuyeGuanli.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final TokenInterceptor tokenInterceptor;

    public WebConfig(TokenInterceptor tokenInterceptor) {
        this.tokenInterceptor = tokenInterceptor;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 配置 for http://localhost:4200 (寬鬆策略)
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);

        // 配置 for http://localhost:4201 (嚴格策略)
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4201")
                .allowedMethods("GET","POST","OPTIONS")
                .allowedHeaders("Content-Type", "token") // 只允許特定頭部
                .allowCredentials(true)
                .maxAge(3600);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/api/residentLogin", "/resources/**", "/avatars/**", "/api/img/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("classpath:/");
        registry.addResourceHandler("/avatars/**")
                .addResourceLocations("classpath:/static/avatars/");
        registry.addResourceHandler("/api/img/**")
                .addResourceLocations("file:src/main/resources/img/");
    }
}
