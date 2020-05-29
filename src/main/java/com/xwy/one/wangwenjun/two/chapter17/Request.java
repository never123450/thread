package com.xwy.one.wangwenjun.two.chapter17;

/**
 * @description:
 * @author: xwy
 * @create: 8:47 PM 2020/5/23
 **/

public class Request {
    private final String name;
    private final int number;

    public Request(final String name, final int number) {
        this.name = name;
        this.number = number;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + " execute " + this);
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}