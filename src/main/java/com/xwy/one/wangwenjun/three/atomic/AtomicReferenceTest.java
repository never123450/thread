package com.xwy.one.wangwenjun.three.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 6:45 AM 2020/5/30
**/

public class AtomicReferenceTest {

    public static void main(String[] args) {

        AtomicReference<Simple> atomicReference = new AtomicReference<>(new Simple("xxx",18));
        System.out.println(atomicReference.get());

        boolean result = atomicReference.compareAndSet(new Simple("xxx",18), new Simple("b", 2));
        System.out.println(result);

    }

    static class Simple{
        private String name;
        private int age;

        public Simple(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Simple{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}