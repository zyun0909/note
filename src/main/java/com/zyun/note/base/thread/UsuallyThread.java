package com.zyun.note.base.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 普通Thread
 * https://blog.csdn.net/u012168222/article/details/52790400
 */
public class UsuallyThread {

    public static void main(String[] args) {
        try {

            //lambda表达式
            Thread thread1 = new Thread(() -> System.out.println(Thread.currentThread().getName()));

            Thread thread2 = new Thread(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });

            Thread thread3 = new Thread(() -> System.out.println(Thread.currentThread().getName()));

            ExecutorService executor = Executors.newFixedThreadPool(3);
            executor.submit(thread1);
            executor.submit(thread2);
            executor.submit(thread3);

            executor.shutdown();

            executor.awaitTermination(10, TimeUnit.SECONDS);

            System.out.println("结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
