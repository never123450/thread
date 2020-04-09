package com.xwy.three.myLock;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CalculateDemo {

    private int[] nums;

    public CalculateDemo(int line) {
        nums = new int[line];
    }

    public void calc(String line, int index, CountDownLatch latch) {
        String[] nus = line.split(",");//切分出每个值
        int total = 0;
        for (String num : nus) {
            total += Integer.parseInt(num);
        }
        nums[index] = total;//把计算结果放到数组中指定的位置
        System.out.println(Thread.currentThread().getName() + "开始执行计算任务。。。" + line + "结果为：" + total);
        latch.countDown();
    }

    public void sum() {
        System.out.println("汇总线程开始执行。。。");
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        System.out.println("最终结果为：" + total);
    }

    public static void main(String[] args) {
        List<String> contents = readFile();
        int lineCount = contents.size();

        CountDownLatch latch = new CountDownLatch(lineCount);

        CalculateDemo calculateDemo = new CalculateDemo(lineCount);
        for (int i = 0; i < lineCount; i++) {
            int finalI = i;
            new Thread(() -> calculateDemo.calc(contents.get(finalI), finalI, latch));
        }

//        while (Thread.activeCount() > 1) {
//
//        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        calculateDemo.sum();

    }

    private static List<String> readFile() {
        List<String> contents = new ArrayList<>();
        String line = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(""));
            while (line == br.readLine()) {
                contents.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return contents;
    }

}