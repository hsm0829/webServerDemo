package com.web.junit;

import com.web.proxy.ArithmeticCalculatorI;
import com.web.proxy.ArithmeticCalculatorLoggingProxy;
import com.web.proxy.impl.ArithmeticCalculatorImpl;

public class Test {

    public static void main(String[] args) {
        ArithmeticCalculatorI target=new ArithmeticCalculatorImpl();
        ArithmeticCalculatorI proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
        int result=proxy.add(1,2);
        System.out.println("-->"+result);
        result=proxy.sub(4,2);
        System.out.println("-->"+result);
    }
}
