//package com.flightbookingsystem.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
//
//    @Override
//    public void commence(HttpServletRequest request,
//                         HttpServletResponse response,
//                         AuthenticationException authException) throws IOException, ServletException {
//        Map<String, Object> errorResponse = new HashMap<>();
//        errorResponse.put("error", "Unauthorized");
//        errorResponse.put("message", "Authentication failed: " + authException.getMessage());
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonResponse = objectMapper.writeValueAsString(errorResponse);
//        response.setContentType("application/json");
//        response.setStatus(HttpStatus.UNAUTHORIZED.value());
//
//        response.getWriter().write(jsonResponse);
//    }
//}
