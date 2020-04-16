package com.base.java.thread.order.fork3;

/**
 *
 * ForkJoinPool中每个线程都有自己的工作队列，并且采用Work-Steal算法防止线程饥饿。 Worker线程用LIFO的方法取出任务，但是会用FIFO的方法去偷取别人队列的任务，这样就减少了锁的冲突。
 * @author tangwei
 * @date 2020/4/16 18:00
 */
public class ForkJoinPoolDemo {

    public static void main(String[] args) {

    }
}
