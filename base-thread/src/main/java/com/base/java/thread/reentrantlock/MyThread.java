package com.base.java.thread.reentrantlock;

/**
 * @author tangwei
 * @date 2018/12/28 10:52
 */
public class MyThread extends Thread{
    private MyService myService;

    public MyThread(MyService service) {
        super();
        this.myService = service;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}
