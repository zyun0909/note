package com.zyun.note.basics.lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedTest {

    /**
     * 不加锁：线程调用该方法相互间不会影响，即可同时调取该方法，不会阻塞
     *
     * @param flag
     */
    public void example0(String flag) {
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("%s：%s进入synchronized方法", getNowTime(), flag));
    }

    /**
     * TODO 验证下
     * 方法体内加锁：线程调用该方法相互间不会影响，即可同时调取该方法
     *
     * @param flag
     */
    public void example1(String flag) {
        synchronized (this) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("%s：%s进入synchronized方法", getNowTime(), flag));
        }
    }

    /**
     * TODO 验证下
     * 方法加锁：
     *
     * @param flag
     */
    public synchronized void example2(String flag) {
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("%s：%s进入synchronized方法", getNowTime(), flag));
    }

    private String getNowTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        return formatter.format(new Date());
    }

    public static void main(String[] args) {
        SynchronizedTest test = new SynchronizedTest();
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String threadName = Thread.currentThread().getName();

                test.example0(threadName);

                //test.example1(threadName);

            }
        });

        ExecutorService executors = Executors.newFixedThreadPool(2);
        executors.submit(thread);
        executors.submit(thread);
    }

}
