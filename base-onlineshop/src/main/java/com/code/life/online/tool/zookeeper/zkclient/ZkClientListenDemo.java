package com.code.life.online.tool.zookeeper.zkclient;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;

/**
 * @author tangwei
 * @date 2019/6/20 13:56
 */
public class ZkClientListenDemo {

    public static void main(String[] args) throws InterruptedException {
        String path = "/zk-client";

        ZkClient client = new ZkClient("127.0.0.1:2181", 5000);

        client.subscribeChildChanges(path, new IZkChildListener() {
            @Override
            public void handleChildChange(String s, List<String> list) throws Exception {
                System.out.println(s + "的子节点改变了， 目前的子节点是" + list);
            }
        });
        client.createPersistent(path);
        Thread.sleep(1000);
        System.out.println(client.getChildren(path));

        client.createPersistent(path + "/demo");
        Thread.sleep(1000);
        System.out.println(client.getChildren(path));

        client.delete(path + "/demo");
        Thread.sleep(1000);
        System.out.println(client.getChildren(path));
        client.delete(path);
        Thread.sleep(Integer.MAX_VALUE);
    }
}
