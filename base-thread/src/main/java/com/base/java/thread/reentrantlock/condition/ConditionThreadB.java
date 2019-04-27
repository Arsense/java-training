package com.base.java.thread.reentrantlock.condition;


import com.base.java.thread.reentrantlock.MyService;

import java.util.concurrent.locks.Lock;

/**
 * @author tangwei
 * @date 2018/12/28 11:07
 */
public class ConditionThreadB extends Thread {
    private MyService myService;
    ConditionThreadB(MyService myService){
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }

}
