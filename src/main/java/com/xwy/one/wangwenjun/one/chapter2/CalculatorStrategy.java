package com.xwy.one.wangwenjun.one.chapter2;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 5:40 PM 2020/5/10
**/

@FunctionalInterface
public interface CalculatorStrategy {

    double calculate(double salary, double bonus);
}
