package com.xwy.two.concurrent.chapter7;

/***************************************
 * @author:xwy
 * @Date:2019年09月17日19:32:27
 ***************************************/
public class UsePersonThread extends Thread {
    private Person person;

    public UsePersonThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " print " + person.toString());
        }
    }
}