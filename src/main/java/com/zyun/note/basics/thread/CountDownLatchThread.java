package com.zyun.note.basics.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 采用闭锁CountDownLatch的方式，保证所有线程都执行完后再执行某操作
 */
public class CountDownLatchThread {

    final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();//线程池
        CountDownLatch latch = new CountDownLatch(2);//初始化前期线程需要完成后再执行下一步数量

        Worker worker1 = new Worker("张三", 5000, latch);
        Worker worker2 = new Worker("李四", 8000, latch);

        es.submit(worker1);
        es.submit(worker2);

        latch.await();//等待所有工人完成工作

        System.out.println("所有人的工作都完成于 " + sdf.format(new Date()));
        System.out.println("前期准备工作都做完了了，开始某操作");

        System.exit(0);
    }


    static class Worker extends Thread {
        private String workerName;
        private int workTime;
        private CountDownLatch latch;

        public Worker(String workerName, int workTime, CountDownLatch latch) {
            this.workerName = workerName;
            this.workTime = workTime;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("Worker " + workerName + " 开始工作于 " + sdf.format(new Date()));
            doWork();//工作了
            System.out.println("Worker " + workerName + " 工作完成于 " + sdf.format(new Date()));
            latch.countDown();//工人完成工作，计数器减一

        }

        private void doWork() {
            try {
                Thread.sleep(workTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
