package com.code.life.online.tool.order;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *
 * 分布式锁
 * @author Clay
 * @date 2019/5/19 14:59
 */
public class ZKdistributeLock implements Lock {

    private String lockPath;


    private ZkClient client;

    public ZKdistributeLock(String lockPath){
        super();
        this.lockPath = lockPath;
        client = new ZkClient("localhost:2181");
        client.setZkSerializer(new MyZkSerializer());
    }
    @Override
    public void lock() {
        //如果获取不到锁 阻塞等待
        if(!tryLock()) {
            //没获得锁 阻塞自己
            waitForLock();
            lock();
        }
    }


    private void waitForLock() {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        IZkDataListener listener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                //删除节点 阻塞计数减一
                System.out.println("----收到节点被删除了");
                countDownLatch.countDown();
            }
            @Override
            public void handleDataDeleted(String s) throws Exception {
            }
        };
        //注册节点
        client.subscribeChildChanges(lockPath, (IZkChildListener) listener);
        if (this.client.exists(lockPath)) {
            try {
                countDownLatch.await();//计数加一
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //取消注册
        client.unsubscribeChildChanges(lockPath, (IZkChildListener) listener);
    }

    @Override
    public boolean tryLock() {  //不会阻塞
        //创建节点
        try {
            client.createEphemeral(lockPath);
        } catch (ZkNodeExistsException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        client.delete(lockPath);
    }

    @Override
    public Condition newCondition() {
        return null;
    }



    @Override
    public void lockInterruptibly() throws InterruptedException {

    }
}
