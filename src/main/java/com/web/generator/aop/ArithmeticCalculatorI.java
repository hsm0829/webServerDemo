package com.web.generator.aop;

/**
 * 计算器
 */
public interface ArithmeticCalculatorI {
    /**
     * 加
     * @param i
     * @param j
     * @return
     */
    int add(int i, int j);

    /**
     * 减
     * @param i
     * @param j
     * @return
     */
    int sub(int i, int j);

    /**
     * 乘
     * @param i
     * @param j
     * @return
     */
    int mul(int i, int j);

    /**
     * 除
     * @param i
     * @param j
     * @return
     */
    int div(int i, int j);

}
