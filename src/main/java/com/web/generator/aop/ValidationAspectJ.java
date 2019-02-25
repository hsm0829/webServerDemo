package com.web.generator.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 切面的优先级：@Order可以设置切换的优先级，值越小，优先级越高
 */
@Order(1)
@Aspect
@Component
public class ValidationAspectJ {

    @Before("execution(* com.web.generator.aop.ArithmeticCalculatorI.*(..))")
    public void validaMethod(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println("the method "+name+" valida with "+ Arrays.asList(joinPoint.getArgs()));
    }
}
