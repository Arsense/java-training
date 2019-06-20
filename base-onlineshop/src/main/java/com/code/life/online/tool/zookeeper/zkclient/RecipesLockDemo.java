package com.code.life.online.tool.zookeeper.zkclient;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.net.InterfaceAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @author tangwei
 * @date 2019/6/20 16:21
 */
public class RecipesLockDemo {
    private static final String MASTER_PATH = "/master_recipes";
    private static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("127.0.0.1:2181")
            .retryPolicy(new ExponentialBackoffRetry(1000,3)).build();
    public static void main(String[] args) {
        client.start();
        InterProcessMutex lock = new InterProcessMutex(client, MASTER_PATH);
        CountDownLatch downLatch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        downLatch.await();
                        lock.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss|SSS");
                    String orderNo = dateFormat.format(new Date());
                    System.out.println("订单号为:" + orderNo);
                    try {
                        lock.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        downLatch.countDown();
    }
}
