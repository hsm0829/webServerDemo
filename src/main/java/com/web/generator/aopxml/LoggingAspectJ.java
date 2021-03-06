package com.web.generator.aopxml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

/**
 * 把这个类声明成一个切面
 */
public class LoggingAspectJ {

    /**
     * 前置通知
     * @param joinPoint
     */
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("the method "+methodName+" begins with "+ Arrays.asList(joinPoint.getArgs()));
    }
    /**
     * 后置通知：在目标方法执行后，无论是否异常，都会执行
     * 在后置通知中，还不能访问目标方法执行的结果
     * @param joinPoint
     */
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("the method "+methodName+" ends with "+ Arrays.asList(joinPoint.getArgs()));
    }

    /**
     * 返回通知：目标方法正常结束后执行
     * 在返回通知中，可以访问到目标方法的返回值
     * @param joinPoint
     * @param result
     */
    public void afterReturnMethod(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("the method "+methodName+" result ="+ result);
    }

    /**
     * 异常通知：在目标方法出现异常时，执行的代码
     * 可以访问到异常对象，且可以指定在特定异常时，再执行异常通知代码
     * @param joinPoint
     * @param e
     */
    public void throwMethod(JoinPoint joinPoint,Exception e){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("the method "+methodName+" exception ="+ e);
    }

    /**
     * 环绕通知：需要携带 ProceedingJoinPoint 类型的参数
     * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
     * 且环绕通知必须有返回值，即目标方法的返回值
     * @param pjd
     * @return
     */
    public Object aroundMehtod(ProceedingJoinPoint pjd){
        Object result=null;
        String name = pjd.getSignature().getName();
        try {
            //前置通知
            System.out.println("The method name "+name+" begins ...");
            result=pjd.proceed();
            System.out.println("result = "+result);
            //后置通知
            System.out.println("The method name "+name+" ends ...");
            //返回通知
            System.out.println("The method name "+name+" result "+result);
        } catch (Throwable throwable) {
            //异常通知
            System.out.println("The method exception "+throwable);
        }
        return result;
    }

}

