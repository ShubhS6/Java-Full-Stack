package com.springboot_security.springBootSecurity.exceptionHandling;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;
import java.time.LocalDateTime;

public class customAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        LocalDateTime ldt=LocalDateTime.now();
        String msg="Access Denied: you are not that level to access this page";
        String message=(accessDeniedException!=null || accessDeniedException.getMessage()!=null)?/*accessDeniedException.getMessage()*/msg:"Access Denied";
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType("application/json");
        response.getWriter().write("{\"time\":\""+ldt.toString()+"\",\"message\":\""+message+"\"}");
    }
}
