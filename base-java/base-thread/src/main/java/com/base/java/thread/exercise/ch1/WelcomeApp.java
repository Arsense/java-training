package com.base.java.thread.exercise.ch1;

/**
 * @author tangwei
 * @date 2020/4/8 23:03
 */
public class WelcomeApp {

    public static void main(String[] args) {
        //启动线程
        Thread welcomeThread = new WelcomeThread();
        // 启动线程
        welcomeThread.start();
        // 输出“当前线程”的线程名称
        System.out.printf("1.Welcome! I'm %s.%n", Thread.currentThread().getName());
 }


}

class WelcomeThread extends Thread {

    // 在该方法中实现线程的任务处理逻辑
    @Override
    public void run() {
        System.out.printf("2.Welcome! I'm %s.%n", Thread.currentThread().getName());
    }

}