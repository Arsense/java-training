package com.code.life.online.tool.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.nio.file.WatchEvent;
import java.util.concurrent.CountDownLatch;

/**
 * @author Clay
 * @date 2019/6/20 10:52
 */
public class CheckNode implements Watcher {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static ZooKeeper zk;

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        zk = new ZooKeeper("127.0.0.1:2181",5000, new CheckNode());
        try {
            //阻塞 触发Watcher
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String path = "/zk-checkNode-";
        zk.exists(path, true);
        zk.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.setData(path, "123".getBytes(), -1);
        zk.create(path + "demo", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        // -1表示最新版本
        zk.delete(path + "demo", -1);
        zk.delete(path, -1);

        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override
    public void process(WatchedEvent event) {
        //没有状态时唤醒
        try {
            if (Event.EventType.None == event.getType()) {
                countDownLatch.countDown();
            } else if (Event.EventType.NodeCreated == event.getType()) {
                System.out.println("Node(" + event.getPath() + ") Created" ) ;
                zk.exists(event.getPath(),true);


            } else if (Event.EventType.NodeDeleted == event.getType()) {
                System.out.println("Node(" + event.getPath() + ") Deleted" ) ;
                zk.exists(event.getPath(),true);

            } else if (Event.EventType.NodeDataChanged == event.getType()) {
                System.out.println("Node(" + event.getPath() + ") Changed");
                zk.exists(event.getPath(), true);
            }
        }  catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
