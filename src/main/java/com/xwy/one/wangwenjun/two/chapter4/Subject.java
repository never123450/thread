package com.xwy.one.wangwenjun.two.chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 3:24 PM 2020/5/18
**/

public class Subject {
    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState(){
        return this.state;
    }

    public void setState(int state){
        if (state == this.state){
            return;
        }
        this.state = state;
        notifyAllObserver();
    }

    public void attache(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObserver(){
        observers.stream().forEach(Observer::update);
    }

}