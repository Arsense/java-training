package com.code.life.online.tool.zookeeper.zkclient;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author tangwei
 * @date 2019/6/20 15:05
 */
public class CuratorFluentDemo {

    public static void main(String[] args) throws InterruptedException {

        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3);

        CuratorFramework client = CuratorFrameworkFactory.builder()
                            .connectString("127.0.0.1:2181")
                            .sessionTimeoutMs(5000)
                            .retryPolicy(retryPolicy)
                            .build();
        client.start();
        Thread.sleep(Integer.MAX_VALUE);
    }
}
