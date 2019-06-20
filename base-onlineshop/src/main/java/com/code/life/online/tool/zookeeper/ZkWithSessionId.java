package com.code.life.online.tool.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author tangwei
 * @date 2019/6/19 17:01
 */
public class ZkWithSessionId implements Watcher {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181",5000, new ZkWithSessionId());


        try {
            //阻塞 触发Watcher
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long sessionId = zooKeeper.getSessionId();
        byte[] password = zooKeeper.getSessionPasswd();
        //用错误的id与密码

        zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new ZkWithSessionId(),1l,"test".getBytes());
        zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new ZkWithSessionId(),sessionId, password);


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
