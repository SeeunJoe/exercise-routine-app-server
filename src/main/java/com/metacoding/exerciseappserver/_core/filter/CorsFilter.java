package com.metacoding.exerciseappserver._core.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CorsFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("CORS 필터 작동");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String origin = request.getHeader("Origin");
        System.out.println("Origin : "+origin);

        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, PATCH, GET, DELETE, OPTIONS"); // OPTIONS 를 필수로 적어야 함
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Key, Content-Type, Authorization"); // Content-Type, Authorization 필수, X-Key는 커스텀 키
        response.setHeader("Access-Control-Allow-Credentials", "true");
        // Credentials 가 true 일때만 Authorization과 쿠키를 보낼 수 있다, 또한 true 이면 * 를 사용할 수 없다.

        // Preflight 요청을 허용하고 바로 응답하는 코드
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        }else {
            chain.doFilter(req, res);
        }
    }
}