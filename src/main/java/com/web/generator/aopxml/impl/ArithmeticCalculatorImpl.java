package com.web.generator.aopxml.impl;


import com.web.generator.aopxml.ArithmeticCalculatorI;

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
