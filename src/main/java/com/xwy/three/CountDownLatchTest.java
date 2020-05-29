package com.xwy.three;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: xwy
 * @create: 9:40 AM 2020/4/30
 **/

public class CountDownLatchTest {

    private int[] nums;

    public CountDownLatchTest(int line) {
        nums = new int[line];
    }

    public void clac(String line, int index, CountDownLatch countDownLatch) {
        String[] nus = line.split(",");
        int total = 0;
        for (String num : nus) {
            total += Integer.parseInt(num);
        }
        nums[index] = total;
        System.out.println(Thread.currentThread().getName() + " 执行任务完成。。。" + line + "结果为：" + total);
        countDownLatch.countDown();
    }

    public void sum() {
        System.out.println("汇总线程开始执行......");
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        System.out.println("最终结果：" + total);
    }

    public static void main(String[] args) {

        List<String> contents = readFile();
        int lineCount = contents.size();

        CountDownLatch countDownLatch = new CountDownLatch(lineCount);
        CountDownLatchTest countDownLatchTest = new CountDownLatchTest(lineCount);
        for (int i = 0; i < lineCount; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    countDownLatchTest.clac(contents.get(finalI), finalI, countDownLatch);
                }
            }).start();
        }


//        while (Thread.activeCount() > 2) {
//
//        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.activeCount());
        countDownLatchTest.sum();

    }

    private static List<String> readFile() {
        List<String> contents = new ArrayList<>();
        String line = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/Users/xuwenyan/Downloads/study/thread/src/main/java/com/xwy/three/countDownLatchText.txt"));
            while ((line = br.readLine()) != null) {
                contents.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return contents;
    }

}