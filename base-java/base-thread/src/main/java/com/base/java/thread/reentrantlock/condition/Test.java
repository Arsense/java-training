package com.base.java.thread.reentrantlock.condition;

/**
 * @author tangwei
 * @date 2018/12/28 11:09
 */
public class Test {
    public static void main(String[] args) {
        ConditionService service = new ConditionService();
        ConditionThreadA a = new ConditionThreadA(service);
        a.start();
        service.signal();
    }
}
