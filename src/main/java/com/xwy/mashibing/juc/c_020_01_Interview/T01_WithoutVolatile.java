/**
 * 实现一个容器，提供2个方法，add，size
 * 写2个线程，线程1添加10个元素到容器之后，线程2监控元素的个数，当个数到5个时，线程2给出提示并结束
 *
 *分析下面这个程序，能完成这个功能吗
 *
 * @author mashibing
 */
package com.xwy.mashibing.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class T01_WithoutVolatile {

	List lists = new ArrayList();

	public void add(Object o) {
		lists.add(o);
	}

	public int size() {
		return lists.size();
	}
	
	public static void main(String[] args) {
		T01_WithoutVolatile c = new T01_WithoutVolatile();

		new Thread(() -> {
			for(int i=0; i<10; i++) {
				c.add(new Object());
				System.out.println("add " + i);
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "t1").start();
		
		new Thread(() -> {
			while(true) {
				if(c.size() == 5) {
					break;
				}
			}
			System.out.println("t2 ????");
		}, "t2").start();
	}
}
