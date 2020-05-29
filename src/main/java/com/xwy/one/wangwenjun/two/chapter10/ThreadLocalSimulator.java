package com.xwy.one.wangwenjun.two.chapter10;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: xwy
 * @create: 11:03 PM 2020/5/21
 **/

public class ThreadLocalSimulator<T> {

    private final Map<Thread, T> storage = new HashMap<>();

    public void set(T t) {
        synchronized (this) {
            Thread key = Thread.currentThread();
            storage.put(key, t);
        }
    }

    public T get() {
        synchronized (this) {
            Thread key = Thread.currentThread();
            T value = storage.get(key);
            if (value == null) {
                return initValue();
            }
            return value;
        }
    }

    private T initValue() {
        return null;
    }
}