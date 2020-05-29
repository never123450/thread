package com.xwy.one.wangwenjun.two.chapter5;

public class User extends Thread {
    private final String myName;

    private final String myAddress;

    private final Gate gate;

    public User(Gate gate,String myName,String myAddress){
        this.gate = gate;
        this.myAddress = myAddress;
        this.myName = myName;
    }

    @Override
    public void run() {
        System.out.println(myName + " BEGIN");
        while (true){
            this.gate.pass(myName,myAddress);
        }
    }
}