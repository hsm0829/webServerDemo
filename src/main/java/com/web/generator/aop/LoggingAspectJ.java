package com.web.generator.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 把这个类声明成一个切面
 */
@Aspect
@Component
public class LoggingAspectJ {

    /**
     * 前置通知
     * @param joinPoint
     */
    @Before("execution(* com.web.generator.aop.ArithmeticCalculatorI.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("the method "+methodName+" begins with "+ Arrays.asList(joinPoint.getArgs()));
    }
    /**
     * 后置通知：在目标方法执行后，无论是否异常，都会执行
     * 在后置通知中，还不能访问目标方法执行的结果
     * @param joinPoint
     */
    @After("execution(* com.web.generator.aop.ArithmeticCalculatorI.*(..))")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("the method "+methodName+" ends with "+ Arrays.asList(joinPoint.getArgs()));
    }
}

