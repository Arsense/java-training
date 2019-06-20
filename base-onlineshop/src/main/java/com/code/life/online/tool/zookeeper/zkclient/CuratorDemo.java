package com.code.life.online.tool.zookeeper.zkclient;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author tangwei
 * @date 2019/6/20 14:56
 */
public class CuratorDemo {

    public static void main(String[] args) throws InterruptedException {
        //重试机制吗?
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3);
        CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181",
                5000,
                3000,
                retryPolicy);
        client.start();
        Thread.sleep(5000);
    }
}
