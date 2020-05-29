package com.xwy.one.wangwenjun.two.chapter11;

import java.util.stream.IntStream;

/**
 * @description:多线程运行上下文设计模式
 * @author: xwy
 * @create: 4:31 PM 2020/5/22
 **/

public class ContextTest {

    public static void main(String[] args) {

        IntStream.range(1, 5).forEach(
                i -> {
                    new Thread(new ExecutionTask()).start();
                });
    }
}