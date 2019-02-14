package com.web.generator.aop.impl;

import com.web.generator.aop.ArithmeticCalculatorI;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ArithmeticCalculatorImpl implements ArithmeticCalculatorI {
    @Override
    public int add(int i, int j) {
        int result=i+j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result=i-j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result=i*j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result=i/j;
        return result;
    }
}
