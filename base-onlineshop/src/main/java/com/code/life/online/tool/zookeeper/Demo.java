package com.code.life.online.tool.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 *  思路 创建连接 -> 创建一个最基本的ZooKeeper会话实例
 * @author tangwei
 * @date 2019/6/19 16:17
 */
public class Demo implements Watcher {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) throws IOException {
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181",5000, new Demo());
        System.out.println(zooKeeper.getState());
        try {
            //阻塞 触发Watcher
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("连接建立了");
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            countDownLatch.countDown();
        }
    }
}
