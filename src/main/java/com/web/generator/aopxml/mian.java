package com.web.generator.aopxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mian {

    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("aop-xml.xml");

        ArithmeticCalculatorI arithmeticCalculator= (ArithmeticCalculatorI) ctx.getBean("arithmeticCalculator");

        System.out.println(" aop class "+arithmeticCalculator.getClass().getName());

        arithmeticCalculator.add(2,2);

        arithmeticCalculator.div(4,2);
    }
}
