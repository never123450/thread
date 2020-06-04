2020年05月10日18:11:15

创建线程

    1. Java应用程序的main函数是一个线程，是被JVM启动的时候调用，线程的名字叫main
    2. 实现一个线程，必须创建Thread实例，override run 方法，并且调用start方法
    3. 在JVM启动后，实际上有多个线程，但是至少有一个非守护线程
    4. 当你调用一个线程start方法的时候，此时只是有2个线程，还有一个执行run方法的线程
    5. 线程的生命周期氛围new，Runnable，running，block，termate


    1. 创建线程对象Thread，默认有一个线程名，以Thread-开头，从0开始计数
    2. 如果在狗仔Thread的时候没有传递Runnable或者没有复写Thread的run方法，该Thread将不会调用任何东西，
    如果传递了Runnable接口的实例，或者复写了Thread的run方法，则会执行该方法的逻辑单元（逻辑代码）
    3. 如果构造线程对象时未传入ThreadGroup，Thread默认会获取父线程的ThreadGroup，此时，
    子线程和父线程将会在同一个ThreadGroup
    4. 构造Thread的时候传入stacksize代表着该线程占用的stack的大小，如果没有指定stacksize的大小，默认是0，
    0代表着会忽略该参数，该参数会被JNI去使用，需要注意：该参数有一些平台有效，在有些平台平台则是无效

wait和sleep的本质区别

    1. sleep是Thread的方法，wait是Object的方法
    2. sleep不会释放锁，wait会释放锁
    3. sleep不依赖于monitor，wait依赖monitor
    4. sleep不需要唤醒，wait需要唤醒


Java内存模型以及CPU缓存不一致的引入

解决方案
	
	1. 给数据总线加锁
	2. CPU高速缓存一致性协议

核心思想：

	1. 当CPU写入数据的时候，如果发现该变量被共享（也就是说，在其他cpu中冶存在该变量的副本），
	会发出一个信号，通知其他cpu该变量的缓存无效。
	2. 当其他cpu访问该变量的时候，重新到主内存中进行获取
	
	
	
2020年05月18日15:22:24

并发编程中的三个比较重要的概念

    1. 原子性 ： i=9;
        一个操作或者多个操作，要么都成功，要么都失败，中间不能由任何的因素中断
        对基本数据类型的变量读取和赋值是保证了原子性的
        i = 10
        cache 10, memory 10
        a=10; 原子性
        b=a; 不满足，1.read a; 2. assign b;
        c++; 不满足，1.read c; 2. add; 3.assign to c;
        c=c+1; 不满足， 1.read c; 2. add; 3.assign to c;
        
    2. 一致性
        Thread-1 int i=0;
        Thread-2 int j=1;
        Thread-1和Thread-2的cache都互不可见，都是需要刷新到主内存才能看见
        
    3. 有序性
	    int i=0;
	    boolean flag=false;
	    i=1;
	    flag=true;
	    
	    重排序只要求最终一致性
	    happens-before relationship
	    
	    3.1  代码的执行顺序，编写在前的发生在编写在后面的
	    3.2  unlock必须发生在lock之后
	    3.3  volatile修饰的变量。对一个变量的写操作先于该变量的读操作
	    3.4  传递规则，操作A先于B，B先于C，那么A肯定先于C
	    3.5  线程启动规则，start方法肯定先于线程run
	    3.6  线程中断规则，interrupt这个动作，必须发生在捕获该动作之前
	    3.7  对象销毁规则，对象的初始化必须发生在finalize之前
	    3.8  线程终结规则，所有的操作都发生在线程死亡之前
	    
	    
	    
	 

volatile关键字

    一旦一个共享变量被volatile修饰，具备2层语义
    1. 保证了不同线程间的可见性
    2. 禁止对其进行指令重排序，也就是保证了有序性
    3. 并未保证原子性
    
    保证重排序的是不会把后面的指令放到屏障的前面，也不会把前面的放到后面
    强制对缓存的修改操作立即写入主内存
    如果是写操作，他会发哦之其他CPU中的缓存失效


    使用场景：
    1. 状态量标记
    2. 屏障前后的一致性
    


    1.不可变对象一定是线程安全的
    2.可变对象不一定是不安全的
    
    servlet     不是线程安全的
    struts1.x   Action也不是线程安全的
    Struts2.x   Action是线程安全的



类主动使用的六种情况

	使用的java虚拟机实现必须在每个类或者接口被java程序首次主动使用才会初始化，当然现代JVM有可能根据程序的上下文语义推断出接下来可能初始化谁
	new，直接使用
	调用某各类或者接口的静态变量，或者对该静态变量赋值
	调用静态方法
	反射某各类
	初始化一个子类
	启动类
	

注意：

    通过子类访问父类的static变量，不会导致子类的初始化

    定义数组，不会初始化类

    final修饰的常量会在编译期间放到常量池，不会初始化类

    final修饰的复杂类型，在编译期间无法计算得出，会初始化类


类的加载阶段详解

    类的加载简单来说， 就是将class文件中的二进制数据读取到内存中，将其放在方法区中，
    然后在堆区中创建一个java.lang.Class对象，用来封装在方法区的数据结构
    
1. You may not know the singleton design pattern under concurrent env
2. WaitSet in synchronized monitor
3. Cpu&Cpu cache&Main Memory& Data Bus&Cache Line
4. The volatile key word in deep
5. Java Class Loader
6. Observer to monitor the Thread lifecycle
7. Single Threaded Execution design pattern
8. Immutable design pattern
9. Guarded Suspension design pattern
10. Balking design pattern
11. Producer-Consumer
12. Read-Write L ock design pattern
13. Thread-Per-Message Design Pattern
14. Worker Thread Design Pattern
15. Future Design Pattern
16. Two-Phase Termination Design Pattern
17. The Thread-Specific Storage
18. Active Objects
19. Count Down Design Pattern
20. JMM-Java Memory Model



一共多少季
1.多线程的基础( Thread ,同步, ThreadGroup)等
2.多线程的设计模式, volatile , classloader
3.并发包所有内容
4.讲解并发包的源码剖析
5.actors，协程框架，disruptor
6.RxJava



    1.可见性
    2.有序性
    3.原子性

    1.volatile修饰的变量，能保证前2者
    2.CAS算法，CPU级别的同步指令，相当于乐观锁，它可以检测到其他线程对共享数据的变化情况

CAS轻量级锁，带来的一个严重的问题，ABA问题


    1. 想让类的属性操作具备原子性
        1.1 volatile
        1.2 非private，protected（如果是当前类也可以是protected
        1.3 类型必须一致
    2.不想使用锁（包括显示锁或者重量级锁Synchronized）
    3.大量需要院子类想修饰的对象，相比较耗费内存
    
    
    
CountDownLatch  VS CyclicBarrier

    1.CountDownLatch不能reset，而CyclicBarrier是可以循环使用
    2.工作线程之间互不关心，工作线程必须等到同一个共同的点才去执行某个动作




    


