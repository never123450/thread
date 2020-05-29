package com.xwy.one.wangwenjun.two.chapter5;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 3:13 PM 2020/5/19
**/

public class Gate {
    private int conuter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    public synchronized void pass(String name,String address){
        this.conuter++;
        this.name = name;
        this.address = address;
        verify();
    }

    private void verify(){
        if (this.name.charAt(0) != this.address.charAt(0)){
            System.out.println("********BROKEN*********"+toString());
        }
    }

    @Override
    public synchronized String toString() {
        return "Gate{" +
                "conuter=" + conuter +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


}