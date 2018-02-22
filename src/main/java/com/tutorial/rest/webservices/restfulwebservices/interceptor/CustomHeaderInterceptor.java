package com.tutorial.rest.webservices.restfulwebservices.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class CustomHeaderInterceptor extends HandlerInterceptorAdapter {
    private static final String HEADER_ACCEPT_LANGUAGE = "accept-language";
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        MDC.put(HEADER_ACCEPT_LANGUAGE, request.getHeader(HEADER_ACCEPT_LANGUAGE));
        return true;
    }

}
