package com.xwy.one.wangwenjun.two.chapter8;

import java.util.function.Consumer;

/**
 * @description:
 * @author: xwy
 * @create: 9:45 PM 2020/5/19
 **/

public class FutureService {
    public <T> Future<T> submit(final FutureTask<T> task) {
        AsyncFuture<T> asyncFuture = new AsyncFuture<>();
        new Thread(() -> {
            T result = task.call();
            asyncFuture.done(result);
        }).start();
        return asyncFuture;
    }

    public <T> Future<T> submit(final FutureTask<T> task, final Consumer<T> consumer) {
        AsyncFuture<T> asyncFuture = new AsyncFuture<>();
        new Thread(() -> {
            T result = task.call();
            asyncFuture.done(result);
            consumer.accept(result);
        }).start();
        return asyncFuture;
    }
}