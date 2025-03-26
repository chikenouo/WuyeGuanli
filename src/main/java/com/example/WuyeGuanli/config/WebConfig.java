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
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200", "http://localhost:4201", "http://localhost:5173","https://wallet-app-react-nu.vercel.app","https://noveres.github.io","http://127.0.0.1:5500/","https://project-wuye-ng.vercel.app")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/api/**")  // 只攔截/api開頭的路徑
                .excludePathPatterns(
                    "/api/auth/login",
                    "/api/residentLogin",
                    "/resources/**",
                    "/api/users/*/avatar",
                    "/api/img/**",
                    "/**/*.html",
                    "/**/*.js",
                    "/**/*.css",
                    "/favicon.ico",
                    "/error",
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/v3/api-docs/**",
                    "/swagger-resources/**",
                    "/webjars/**",
                    "/api/Financial/addInfo",
                    "/api/Financial/search",
                    "/api/Financial/delect");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/");

        registry.addResourceHandler("/api/users/*/avatar")
                .addResourceLocations("file:src/main/resources/static/avatars/");
        registry.addResourceHandler("/api/img/**").addResourceLocations("classpath:/img/");
        registry.addResourceHandler("/assets/images/**")
                .addResourceLocations("classpath:/static/WS/");
    }
}