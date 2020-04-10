package com.xwy.five.synchronize;

/**
 * @description: Synchronized修饰方法和代码块有啥区别
 * @author: xwy
 * @create: 12:56 PM 2020/4/10
 **/

public class SyncTest {

    //   flags: ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
    public static synchronized int get() {
        return 0;
    }

    //  flags: ACC_PUBLIC, ACC_SYNCHRONIZED
    public synchronized void get1(){

    }

    public void test() {
        // monitorenter
        synchronized (SyncTest.class) {
            System.out.println("test");
        }
        // monitorexist
    }

}


/*

{
  public com.xwy.five.synchronize.SyncTest();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 9: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lcom/xwy/five/synchronize/SyncTest;

 public synchronized void get1();
    descriptor: ()V
    flags: ACC_PUBLIC, ACC_SYNCHRONIZED
    Code:
      stack=0, locals=1, args_size=1
         0: return
      LineNumberTable:
        line 18: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       1     0  this   Lcom/xwy/five/synchronize/SyncTest;

  public static synchronized int get();
    descriptor: ()I
    flags: ACC_PUBLIC, ACC_STATIC, ACC_SYNCHRONIZED
    Code:
      stack=1, locals=0, args_size=0
         0: iconst_0
         1: ireturn
      LineNumberTable:
        line 12: 0

  public void test();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=3, args_size=1
         0: ldc           #2                  // class com/xwy/five/synchronize/SyncTest
         2: dup
         3: astore_1
         4: monitorenter
         5: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
         8: ldc           #4                  // String test
        10: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        13: aload_1
        14: monitorexit
        15: goto          23
        18: astore_2
        19: aload_1
        20: monitorexit
        21: aload_2
        22: athrow
        23: return

*/

