package com.code.life.online.tool.zookeeper.zkclient;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicInteger;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;

/** 分布式计数器
 * @author tangwei
 * @date 2019/6/20 16:40
 */
public class DisAtomicInt {

    private static final String MASTER_PATH = "/master_disatomic";
    private static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("127.0.0.1:2181")
            .retryPolicy(new ExponentialBackoffRetry(1000,3)).build();

    public static void main(String[] args) throws Exception {
        client.start();
        DistributedAtomicInteger atomicInteger = new DistributedAtomicInteger(client,
                                            MASTER_PATH,new RetryNTimes(3, 1000));
        AtomicValue<Integer> result = atomicInteger.add(8);
        System.out.println("Result :" + result.succeeded());
    }
}
