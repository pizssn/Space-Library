package com.pizssn.sl.interceptor;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 放行 options 请求，否则无法让前端带上自定义的 header 信息，导致 sessionID 改变，shiro 验证失败
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.isRemembered());
        System.out.println(subject.isAuthenticated());
        // 使用 shiro 验证
        if (!subject.isAuthenticated() && !subject.isRemembered()) {
            return false;
        }
        return true;
    }
}
