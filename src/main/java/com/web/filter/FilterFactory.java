package com.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器
 */
public class FilterFactory implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器开始工作........");
        filterChain.doFilter(servletRequest, servletResponse);//放行.......
        System.out.println("过滤器工作完成........");
    }

    @Override
    public void destroy() {

    }
}
