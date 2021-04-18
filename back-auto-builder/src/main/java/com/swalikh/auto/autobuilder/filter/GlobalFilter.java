package com.swalikh.auto.autobuilder.filter;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Copyright @2018 nlelpct.
 * date:  2019/4/9  15:50
 * use to：全局拦截获取jwt数据
 * modify：
 */
@Slf4j
@Component
@WebFilter(filterName = "myFilter", urlPatterns = "/*")
public class GlobalFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(GlobalFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest requests, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            // 1.从request中获取jwt信息并且进行线程存储

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            chain.doFilter(requests, response);
        }
    }

    @Override
    public void destroy() {

    }
}