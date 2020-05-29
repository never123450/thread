package com.xwy.one.wangwenjun.two.chapter7;

import java.util.Collections;
import java.util.List;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 9:02 PM 2020/5/19
**/

public class ImmuableTest {

    private final int age;
    private final String name;
    private final List<String> list;

    public ImmuableTest(int age, String name, List<String> list) {
        this.age = age;
        this.name = name;
        this.list = list;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {
        return Collections.unmodifiableList(list);
    }

}