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
import java.util.Arrays;
import java.util.List;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    private final JwtUtils jwtUtils;
    private static final Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);
    private static final List<String> ALLOWED_ORIGINS = Arrays.asList(
        "http://localhost:4200",
        "http://localhost:5173",
        "https://wallet-app-react-nu.vercel.app",
            "https://noveres.github.io/fgbd/"
    );

    // 哪些路徑需要完全放行（不需要驗證token）
    private static final List<String> ALLOWED_PATHS = Arrays.asList(
        "/wallet/**",
        "/money/**",
        "/fee/**",
        "/rental/**",
       "/api/residents/getAll",
            "/api/residents/Add",
            "/api/repairs",
            "/api/residents",
            "/api/visitors",
            "/api/visitors/Add"
    );

    public TokenInterceptor(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 檢查是否為預檢請求（OPTIONS）
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        // 檢查請求路徑是否屬於放行路徑
        String requestPath = request.getRequestURI();
        for (String allowedPath : ALLOWED_PATHS) {
            if (requestPath.startsWith(allowedPath)) {
                logger.debug("Path {} is allowed without token", requestPath);
                return true;
            }
        }

        // 檢查Origin是否為允許的前端來源
        String origin = request.getHeader("Origin");
        if (origin != null && ALLOWED_ORIGINS.contains(origin)) {
            // 只有在使用Session的路徑才放行
            if (requestPath.startsWith("/wallet/") || requestPath.startsWith("/money/")) {
                logger.debug("Request from {} to {} is allowed without token", origin, requestPath);
                return true;
            }
        }

        // 取得並驗證token
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        // 沒有token且不在允許的路徑，拒絕訪問
        if (token == null || token.isEmpty()) {
            logger.warn("Token not provided for path: {}", requestPath);
            return returnError(response, "請提供有效的令牌");
        }

        // 驗證token
        try {
            if (jwtUtils == null) {
                throw new Exception("jwtUtils is null");
            }
            jwtUtils.parseToken(token);
            return true;
        } catch (Exception e) {
            logger.error("Token validation failed for path {}: {}", requestPath, e.getMessage());
            return returnError(response, "令牌無效");
        }
    }

    private boolean returnError(HttpServletResponse response, String message) throws Exception {
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