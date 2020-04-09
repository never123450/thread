package com.xwy.two.concurrent.chapter8;

import java.util.function.Consumer;

/***************************************
 * @author:xwy
 * @Date:2019年09月18日15:55:50
 ***************************************/
public class FutureService {

    public <T> Future<T> submit(final FutureTask<T> task) {
        AsynFuture<T> asynFuture = new AsynFuture<>();
        new Thread(() -> {
            T result = task.call();
            asynFuture.done(result);
        }).start();
        return asynFuture;
    }

    public <T> Future<T> submit(final FutureTask<T> task, final Consumer<T> consumer) {
        AsynFuture<T> asynFuture = new AsynFuture<>();
        new Thread(() -> {
            T result = task.call();
            asynFuture.done(result);
            consumer.accept(result);
        }).start();
        return asynFuture;
    }
}