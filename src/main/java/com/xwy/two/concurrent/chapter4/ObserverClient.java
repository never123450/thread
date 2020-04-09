package com.xwy.two.concurrent.chapter4;

/***************************************
 * @author:xwy
 * @Date:2019年09月14日21:33:21
 ***************************************/
public class ObserverClient {
    public static void main(String[] args) {

        final Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        System.out.println("==================");
        subject.setState(10);
        System.out.println("==================");
        subject.setState(10);

        System.out.println("==================");
        subject.setState(15);
    }
}
