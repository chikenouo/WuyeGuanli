package com.example.WuyeGuanli.interceptor;

import com.example.WuyeGuanli.utils.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashMap;
import java.util.Map;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    private final JwtUtils jwtUtils;
    private static final Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);

    public TokenInterceptor(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 檢查Origin或Referer，如果來自4200則允許通過
        String origin = request.getHeader("Origin");
        if (origin != null && origin.equals("http://localhost:4200")) {
            return true; // 直接放行來自4200的請求
        }

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        if (token == null || token.isEmpty()) {
            return returnError(response, "請提供有效的令牌");
        }

        try {
            if (jwtUtils == null){
                throw new Exception("jwtUtils is null");
            }
            jwtUtils.parseToken(token);
        } catch (Exception e) {
            logger.error("Token validation failed", e);
            return returnError(response, "令牌無效");
        }

        return true;
    }

    private boolean returnError(HttpServletResponse response, String message) throws Exception{
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Map<String, Object> error = new HashMap<>();
        error.put("code", 0);
        error.put("msg", message);
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(error));
        return false;
    }
}