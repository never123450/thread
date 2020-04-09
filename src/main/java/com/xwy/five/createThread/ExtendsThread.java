package com.xwy.five.createThread;

/**
 * @description: 创建线程的方式一：继承Thread类
 * @author: xwy
 * @create: 8:43 PM 2020/4/9
 **/

public class ExtendsThread extends Thread {

    public ExtendsThread(String name) {
        super(name);
    }

    public ExtendsThread(){

    }

    @Override
    public void run() {
        System.out.println(getName() + "   线程执行了！");
    }



    public static void main(String[] args) {
        ExtendsThread extendsThread = new ExtendsThread();
        ExtendsThread extendsThread1 = new ExtendsThread();


        ExtendsThread extendsThread2 = new ExtendsThread("线程名");//带参数的构造函数
        /*
         直接调用run()的话就是普通的调用方法，会按顺序执行
         而调用start()方法才是真正的启动一个线程，调用之后线程处于就绪状态，等待CPU时间片，执行顺序是不一定的
          */
//        extendsThread.run();

        //当主线程退出的时候，不管该线程是否执行完毕都退出，只能写在start之前
        extendsThread.setDaemon(true);

        extendsThread1.start();
        extendsThread.start();
        extendsThread2.start();

        extendsThread.interrupt();
//        extendsThread.stop();//过时了，不推荐使用

    }
}