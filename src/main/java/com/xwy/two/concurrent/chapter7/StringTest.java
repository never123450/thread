package com.xwy.two.concurrent.chapter7;

/***************************************
 * @author:xwy
 * @Date:2019年09月17日19:37:51
 ***************************************/
public class StringTest {
    public static void main(String[] args) {
        String s = "Hello";
        String s2 = s.replace("l", "k");
        System.out.println(s + "   " + s2);
        System.out.println(s2.getClass() + " " + s2.hashCode());
        System.out.println(s.getClass() + " " + s.hashCode());
    }
}
