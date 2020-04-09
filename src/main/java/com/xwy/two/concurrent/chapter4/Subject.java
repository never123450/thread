package com.xwy.two.concurrent.chapter4;

import java.util.ArrayList;
import java.util.List;

/***************************************
 * @author:xwy
 * @Date:2019年09月14日21:27:34
 ***************************************/
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        if (state == this.state) {
            return;
        }
        this.state = state;
        notifyAllObserver();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    private void notifyAllObserver() {
        observers.stream().forEach(Observer::update);
    }
}