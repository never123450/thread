package com.xwy.one.wangwenjun.two.chapter7;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 7:16 PM 2020/5/19
**/

public class Person {

    private final String name;

    private final String address;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


}