package com.base.java.thread.order;

import com.base.java.thread.order.domain.*;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author tangwei
 * @date 2020/4/16 17:09
 */
public class CountDownTask {

    private static final int CORE_POOL_SIZE = 4;
    private static final int MAX_POOL_SIZE = 12;
    private static final long KEEP_ALIVE_TIME = 5L;
    private final static int QUEUE_SIZE = 1600;

    protected static ThreadFactory namedFactory = new ThreadFactoryBuilder().setNameFormat("我的线程-%d").build();
    protected final static ExecutorService THREAD_POOL = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME,  TimeUnit.SECONDS, new LinkedBlockingQueue<>(QUEUE_SIZE), namedFactory);


    public static void main(String[] args) throws InterruptedException {
        //建立一个线程池(具体配置根据具体业务，具体机器配置)，进行并发的执行我们的任务(生成用户信息，菜品信息等)，最后利用await方法阻塞等待结果成功返回。
        CountDownLatch countDownLatch = new CountDownLatch(5);
        OrderInfo orderInfo = new OrderInfo();

        THREAD_POOL.execute(()-> {
            System.out.println("当前任务Customer,线程名字为:" + Thread.currentThread().getName());
            orderInfo.setCustomerInfo(new CustomerInfo());
            countDownLatch.countDown();
        });

        THREAD_POOL.execute(()-> {
            System.out.println("Discount,线程名字为:" + Thread.currentThread().getName());
            orderInfo.setDiscount(new Discount());
            countDownLatch.countDown();


        });

        THREAD_POOL.execute(()-> {
            System.out.println("当前任务Food,线程名字为:" + Thread.currentThread().getName());
            orderInfo.setFood(new Food());
            countDownLatch.countDown();
        });

        THREAD_POOL.execute(()-> {
            System.out.println("当前任务Tenant,线程名字为:" + Thread.currentThread().getName());
            orderInfo.setTenant(new Tenant());
            countDownLatch.countDown();

        });

        THREAD_POOL.execute(()-> {
            System.out.println("当前任务OtherInfo,线程名字为:" + Thread.currentThread().getName());
            orderInfo.setOtherInfo(new OtherInfo());
            countDownLatch.countDown();
        });

        countDownLatch.await(1, TimeUnit.SECONDS);
        System.out.println("主线程："+ Thread.currentThread().getName());

    }













}
