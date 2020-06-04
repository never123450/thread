package com.xwy.one.wangwenjun.three.utils.CountDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: xwy
 * @create: 10:15 PM 2020/6/2
 **/

public class CountDownLatchExample3 {
//    public static void main(String[] args) throws InterruptedException {
//        final CountDownLatch latch = new CountDownLatch(0);
//        latch.await();
//        System.out.println("---");
//    }

    private static Random random = new Random(System.currentTimeMillis());


    static class Event {
        int id = 0;

        public Event(int id) {
            this.id = id;
        }
    }

    interface Watcher {
        void startWatch();

        void done(Table table);
    }

    static class TaskBacth implements Watcher {

        private CountDownLatch countDownLatch;

        private TaskGroup taskGroup;

        public TaskBacth(TaskGroup taskGroup, int size) {
            this.countDownLatch = new CountDownLatch(size);
            this.taskGroup = taskGroup;
        }


        @Override
        public void startWatch() {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void done(Table table) {
            countDownLatch.countDown();
            if (countDownLatch.getCount() == 0) {
                System.out.println("the table " + table.tableName + " finished work" + table);
                taskGroup.done(table);
            }
        }
    }


    static class TaskGroup implements Watcher {

        private CountDownLatch countDownLatch;

        private Event event;

        public TaskGroup(int size, Event event) {
            this.countDownLatch = new CountDownLatch(size);
            this.event = event;
        }


        @Override
        public void startWatch() {
            try {
                countDownLatch.await();
                if (countDownLatch.getCount() == 0) {
                    System.out.println("All of table done int event " + event.id);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void done(Table table) {
            countDownLatch.countDown();
            if (countDownLatch.getCount() == 0) {
                System.out.println("the table " + table.tableName + " finished work" + table);
            }
        }
    }

    static class Table {
        String tableName;
        long sourceRecoradCount = 10;
        long targrtCount;
        String sourceColumnSchema = "<table name='a'><column name='coll' type='varchar2'></table>";
        String targetColumnSchema = "";

        public Table(String tableName, long sourceRecoradCount) {
            this.tableName = tableName;
            this.sourceRecoradCount = sourceRecoradCount;
        }

        @Override
        public String toString() {
            return "Table{" +
                    "tableName='" + tableName + '\'' +
                    ", sourceRecoradCount=" + sourceRecoradCount +
                    ", targrtCount=" + targrtCount +
                    ", sourceColumnSchema='" + sourceColumnSchema + '\'' +
                    ", targetColumnSchema='" + targetColumnSchema + '\'' +
                    '}';
        }
    }

    private static List<Table> capture(Event event) {
        List<Table> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Table("table-" + event.id + "-" + i, i * 1000));
        }
        return list;
    }


    public static void main(String[] args) {
        Event[] events = {new Event(1), new Event(2)};

        ExecutorService executorService =
                Executors.newFixedThreadPool(5);
        for (Event event : events) {
            List<Table> tables = capture(event);
            TaskGroup taskGroup = new TaskGroup(tables.size(),event);
            for (Table table : tables) {
                TaskBacth taskBacth = new TaskBacth(taskGroup,2);
                TrustSourceResourceClumns trustSourceResourceClumns = new TrustSourceResourceClumns(table, taskBacth);
                TrustSourceResourceCount trustSourceResourceCount = new TrustSourceResourceCount(table, taskBacth);
                executorService.submit(trustSourceResourceClumns);
                executorService.submit(trustSourceResourceCount);
            }
        }
    }

    static class TrustSourceResourceCount implements Runnable {

        private final Table table;

        private final TaskBacth taskBacth;

        public TrustSourceResourceCount(Table table, TaskBacth taskBacth) {
            this.table = table;
            this.taskBacth = taskBacth;
        }


        @Override
        public void run() {

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            table.targetColumnSchema = table.sourceColumnSchema;
            System.out.println("the table " + table.tableName + "record count capture done and update data");
            taskBacth.done(table);

        }
    }

    static class TrustSourceResourceClumns implements Runnable {

        private final Table table;

        private final TaskBacth taskBacth;

        public TrustSourceResourceClumns(Table table, TaskBacth taskBacth) {
            this.table = table;
            this.taskBacth = taskBacth;
        }

        @Override
        public void run() {

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            table.targetColumnSchema = table.sourceColumnSchema;
            System.out.println("the table " + table.tableName + "target columns capture done and update data");
            taskBacth.done(table);
        }
    }


}