package com.base.java.thread.exercise.ch1;

/**
 * @author tangwei
 * @date 2020/4/8 23:08
 */
public class WelcomeApp2 {
    public static void main(String[] args) {

        // 创建线程
        Thread welcomeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.printf("2.Welcome! I'm %s.%n", Thread.currentThread()
                        .getName());
            }
        });

        // 启动线程
        welcomeThread.start();
        // 这里直接调用线程的run方法，仅是出于演示的目的
        welcomeThread.run();
        System.out.printf("1.Welcome! I'm %s.%n", Thread.currentThread().getName());
    }
}
