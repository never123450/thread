## 公平锁

- 公平失针对锁的获取而言的，如果一个锁是公平的，那么获取锁顺序就应该符合请求的绝对时间顺序

## 读写锁

- 排它锁与共享锁



## callable和Runnable的区别

- Runnable的run方法是被线程调用的，他的run方法是异步执行的
- callable的call方法，不是异步执行的，是由future的run方法调用的

- 多线程的目的不仅仅是提高程序的性能
- 但是可以充分利用CPU资源

## CopyOnWriteArrayList