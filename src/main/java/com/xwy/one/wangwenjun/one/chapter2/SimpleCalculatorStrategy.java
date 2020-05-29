package com.xwy.one.wangwenjun.one.chapter2;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 5:40 PM 2020/5/10
**/

public class SimpleCalculatorStrategy implements CalculatorStrategy {

    private final static double SALARY_RATE = 0.1;
    private final static double BONUS_RATE = 0.15;

    @Override
    public double calculate(double salary, double bonus) {
        return salary * SALARY_RATE + bonus * BONUS_RATE;
    }
}
