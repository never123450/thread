package com.xwy.one.wangwenjun.two.chapter18;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 3:21 PM 2020/5/24
**/

public class Servant implements ActiveObject{
    @Override
    public Result makeString(int count, char fillchar) {
        char[] buf = new char[count];
        for (int i = 0; i < count; i++) {
            buf[i] = fillchar;
            try {
                Thread.sleep(10);
            }catch (Exception e){

            }
        }
        return new RealResult(new String(buf));
    }

    @Override
    public void displayString(String text) {
        try {
            System.out.println("Display : " + text);
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}