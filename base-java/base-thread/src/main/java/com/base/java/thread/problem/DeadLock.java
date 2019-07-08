package com.base.java.thread.problem;

/**
 * @author Clay
 * @date 2019/4/24 20:45
 */
public class DeadLock {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                new DeadLock().resource1();
            } catch (Exception e) {
            }
        }).start();

        new Thread(() -> {
            try {
                new DeadLock().resource2();
            } catch (Exception e) {
            }
        }).start();
    }


     void resource1() throws InterruptedException {
        synchronized ("resource1") {
            System.out.println("获取到资源1");
            Thread.sleep(1000);
            resource2();
        }

     }

     void resource2() throws InterruptedException {
        synchronized ("resource2") {
            System.out.println("获取到资源2");
            Thread.sleep(1000);
            resource1();
        }

    }

}
