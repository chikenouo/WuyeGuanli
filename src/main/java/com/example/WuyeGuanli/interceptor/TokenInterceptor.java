package com.example.WuyeGuanli.interceptor;

import com.example.WuyeGuanli.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TokenInterceptor implements HandlerInterceptor {
    private final JwtUtils jwtUtils;

    public TokenInterceptor(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 檢查是否為 OPTIONS 預檢請求，直接放行
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        // 檢查請求來源
        String origin = request.getHeader("Origin");
        if (origin == null || !origin.equals("http://localhost:4201")) {
            return true; // 非 4201 請求，放行
        }

        // 獲取請求頭中的 token
        String token = request.getHeader("token");

        // 判斷 token 是否存在
        if (token == null || token.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{\"code\": 0, \"msg\": \"請提供有效的令牌\"}");
            return false;
        }

        // 驗證 token
        try {
            jwtUtils.parseToken(token);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("{\"code\": 0, \"msg\": \"令牌無效\"}");
            return false;
        }

        return true;
    }
}
