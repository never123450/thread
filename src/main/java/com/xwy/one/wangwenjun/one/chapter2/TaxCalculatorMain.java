package com.xwy.one.wangwenjun.one.chapter2;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 5:41 PM 2020/5/10
**/

public class TaxCalculatorMain {

    public static void main(String[] args) {
        /*TaxCalaculator calculator = new TaxCalaculator(10000d, 2000d) {

            @Override
            public double calcTax() {
                return getSalary() * 0.1 + getBonus() * 0.15;
            }
        };
        double tax = calculator.calculate();
        System.out.println(tax);*/

        TaxCalaculator calculator = new TaxCalaculator(10000d, 2000d, (s, b) -> s * 0.1 + b * 0.15);
        System.out.println(calculator.calculate());
    }
}
