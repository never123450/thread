package com.xwy.five.createThread;

import java.util.Arrays;
import java.util.List;

/**
 * @description: 方法八：使用lambda表达式实现多线程
 * @author: xwy
 * @create: 10:20 PM 2020/4/9
 **/

public class ByLambda {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);
        ByLambda byLambda = new ByLambda();
        int add = byLambda.add(values);
        System.out.println(add);
    }

    public int add(List<Integer> values) {
        values.parallelStream().forEach(System.out::println);
        return values.parallelStream().mapToInt(a -> a).sum();
    }
}