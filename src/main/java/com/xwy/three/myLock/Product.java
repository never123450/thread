package com.xwy.three.myLock;

public class Product {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Product(int id, String name) {
//        new Thread(() -> {
            System.out.println("开始生产" + name);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        }).start();
        this.id = id;
        this.name = name;
        System.out.println(name + "生产完毕");
    }

    @Override
    public String toString() {
        return "id:" + id + " name:" + name;
    }
}