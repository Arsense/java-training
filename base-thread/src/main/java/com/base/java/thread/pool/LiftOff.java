package com.base.java.thread.pool;

/**
 * @author tangwei
 * @date 2018/12/12 9:26
 */
public class LiftOff implements Runnable{

    protected int countDown = 10;
    private static int taskCount = 0;
    private final  int id = taskCount++;
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }
    public LiftOff() { }

    public String status() {
        return "#" + id + "(" +
                (countDown > 0? countDown: "LiftOff") + "). ";
    }

    @Override
    public void run() {
        while(countDown -- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }





}
