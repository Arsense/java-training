package com.code.life.online.tool.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author tangwei
 * @date 2019/6/20 9:32
 */
public class UpdateNode implements Watcher {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181",5000, new UpdateNode());
        System.out.println(zooKeeper.getState());
        try {
            //阻塞 触发Watcher
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String nodePath = "/zk-upload-";
        zooKeeper.create(nodePath, "before".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        zooKeeper.getData(nodePath, true, null);

        Stat stat = zooKeeper.setData(nodePath, "change now".getBytes(),-1);

        System.out.println(stat.getCzxid() + "," + stat.getMzxid() + "," + stat.getVersion());

        Stat stat1 = zooKeeper.setData(nodePath, "change now".getBytes(),stat.getVersion());

        System.out.println(stat1.getCzxid() + "," + stat1.getMzxid() + "," + stat1.getVersion());


        Stat stat2 = zooKeeper.setData(nodePath, "change now".getBytes(), stat.getVersion());

        System.out.println(stat2.getCzxid() + "," + stat2.getMzxid() + "," + stat2.getVersion());
        Thread.sleep(Integer.MAX_VALUE);
        System.out.println("连接建立了");
    }


    @Override
    public void process(WatchedEvent watchedEvent) {
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            if (Event.EventType.None == watchedEvent.getType() && null == watchedEvent.getPath()) {
                countDownLatch.countDown();
            }
        }
    }
}
