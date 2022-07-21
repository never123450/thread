package com.xwy.mashibing;

import java.util.concurrent.ConcurrentHashMap;

public class Tets {
    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("1", "msb");


        int i = 9;
        i = i++;
//        i = ++i;
        System.out.println(i);
    }
}
