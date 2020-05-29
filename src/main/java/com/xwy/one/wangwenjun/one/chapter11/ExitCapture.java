package com.xwy.one.wangwenjun.one.chapter11;

/**
 *
 * @description: 给应用程序注入钩子
 * 抛异常退出之前会打印信息
 * kill强制退出进程不会打印信息
 *
 * @author: xwy
 *
 * @create: 10:25 PM 2020/5/13
**/

public class ExitCapture {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("The application will be exit");
            notifyRelease();
        }));

        int i = 0;
        while (true){
            try {
                Thread.sleep(1_000L);
                System.out.println("i am working...");
            }catch (Throwable e){

            }
            i++;
            if (i>20) throw new RuntimeException("error");
        }

    }

    private static void notifyRelease() {
        System.out.println("notify to the admin");
        try {
            Thread.sleep(1_000);
        }catch (Throwable e){}
        System.out.println("will release resource(socket,file,connection)");
    }
}