package com.web.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 计算器类动态代理，日志处理
 */
public class ArithmeticCalculatorLoggingProxy {

    /**
     * 要代理的对象
     */
    private ArithmeticCalculatorI target;

    public ArithmeticCalculatorLoggingProxy(ArithmeticCalculatorI arithmeticCalculatorI) {
        this.target = arithmeticCalculatorI;
    }

    /**
     * 动态代理
     * @return 返回要代理的对象
     */
    public ArithmeticCalculatorI getLoggingProxy(){
        ArithmeticCalculatorI proxy=null;
        /**
         * 普通类，使用new，java虚拟机有默认的类加载器
         * 代理对象，指定由哪一个类加载器负责加载
         */
        ClassLoader loader = target.getClass().getClassLoader();
        /**
         * 代理对象的类型，即其中有哪些方法
         */
        Class[] interfaces=new Class[]{ArithmeticCalculatorI.class};
        /**
         * 当调用代理对象其中的方法时，执行该代码
         */
        InvocationHandler h=new InvocationHandler() {
            /**
             * @param proxy 正在返回的代理对象，一般在invoke方法中都不使用该对象
             * @param method 正在调用的方法
             * @param args 调用方法传入的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                System.out.println("The method name "+methodName+" begins with "+ Arrays.asList(args));
                //执行方法
                Object result = method.invoke(target, args);
                System.out.println("The method name "+methodName+" ends with "+ result);
                return result;
            }
        };
        //生成代理对象
        proxy= (ArithmeticCalculatorI) Proxy.newProxyInstance(loader,interfaces,h);
        return proxy;
    }


}
