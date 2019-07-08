package com.base.java.thread.reentrantlock.condition;

/**
 * @author Clay
 * @date 2018/12/28 11:07
 */
public class ConditionThreadA extends Thread{
    private ConditionService service;
    ConditionThreadA(ConditionService service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.await();
    }

}
