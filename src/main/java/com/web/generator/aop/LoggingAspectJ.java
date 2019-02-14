package com.web.generator.aop;

import org.aspectj.lang.JoinPoint;
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
}
