package com.xwy.one.wangwenjun.two.chapter18;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 4:09 PM 2020/5/24
**/

public class ActiveObjectTest {
    public static void main(String[] args) {
        ActiveObject activeObject =  ActiveObjectFactory.createActiveObject();
        new MakerClientThread(activeObject,"AAAAA").start();
        new MakerClientThread(activeObject,"BBBBB").start();

        new DisplayClientThread("CCCC",activeObject).start();
    }
}