package com.code.life.online.tool.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/** 异步实现接口
 * @author Clay
 * @date 2019/6/19 17:18
 */
public class CreateNode implements Watcher {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181",5000, new CreateNode());
        System.out.println(zooKeeper.getState());
        try {
            //阻塞 触发Watcher
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        zooKeeper.create("/zk-demo-", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL
            ,new StringCallBack(),"i am context");

        zooKeeper.create("/zk-demo-", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL
                ,new StringCallBack(),"i am context");

        zooKeeper.create("/zk-demo-", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL
                ,new StringCallBack(),"i am context");
        Thread.sleep(Integer.MAX_VALUE);
        System.out.println("连接建立了");
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            countDownLatch.countDown();
        }
    }
}
