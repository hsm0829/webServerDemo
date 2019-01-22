package com.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 */
public class TestInterceptor implements HandlerInterceptor {
    /**
     * 在DispatcherServlet之前执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println(" TestInterceptor  DispatcherServlet 之前 preHandle ");
        //true放行
        //false拦截
        return true;
    }

    /**
     * 在controller执行之后的DispatcherServlet之后执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println(" TestInterceptor controller 执行之后 DispatcherServlet 之前 postHandle ");
    }

    /**
     * 在页面渲染完成返回给客户端之前执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println(" TestInterceptor 页面渲染完成返回给客户端之前 afterCompletion ");
    }
}
