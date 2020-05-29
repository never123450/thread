package com.xwy.one.wangwenjun.two.chapter18;

/**
 *
 * @description: 接受异步消息的主动方法
 *
 * @author: xwy
 *
 * @create: 9:37 PM 2020/5/23
**/

public interface ActiveObject {

    Result makeString(int count,char fillchar);

    void displayString(String text);

}