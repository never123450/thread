package com.xwy.one.wangwenjun.two.chapter7;

import java.util.stream.IntStream;

public class ImmutableClient {
    public static void main(String[] args) {
        Person person = new Person("xxx", "jx");
        IntStream.range(0, 5).forEach(i -> {
            new UsePersonThread(person).start();
        });
    }
}