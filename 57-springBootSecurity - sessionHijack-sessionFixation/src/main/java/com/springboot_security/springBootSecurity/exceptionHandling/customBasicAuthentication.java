package com.springboot_security.springBootSecurity.exceptionHandling;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;
import java.time.LocalDateTime;

public class customBasicAuthentication implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        LocalDateTime ldt=LocalDateTime.now();
        String msg="Wrong either username or password";
        String message=(authException!=null || authException.getMessage()!=null)?/*authException.getMessage()*/msg:"Bad credentials";
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");
        response.getWriter().write("{\"time\":\""+ldt.toString()+"\",\"message\":\""+message+"\"}");
    }
}
