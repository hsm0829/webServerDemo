package com.web.generator.aopxml;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

/**
 * 切面的优先级：@Order可以设置切换的优先级，值越小，优先级越高
 */
public class ValidationAspectJ {

    /**
     * 声明切入点表达式，一般的，该方法不在添加其他代码
     * 其他通知，引用该切点，只用引用该切点的方法名，其他切面引用该切点，需 类名.方法名，不同包需： 包名.类名.方法名
     *
     */
    public void declarationPointCutExpression(){}

    public void validaMethod(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println("the method "+name+" valida with "+ Arrays.asList(joinPoint.getArgs()));
    }
}
