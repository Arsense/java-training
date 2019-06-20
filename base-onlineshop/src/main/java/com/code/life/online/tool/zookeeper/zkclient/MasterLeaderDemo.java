package com.code.life.online.tool.zookeeper.zkclient;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.ExponentialBackoffRetry;


/**
 * 适用于Master选举
 *
 * @author tangwei
 * @date 2019/6/20 15:11
 */
public class MasterLeaderDemo {

    private static final String MASTER_PATH = "/master_path";
    private static CuratorFramework client = CuratorFrameworkFactory.builder()
                        .connectString("127.0.0.1:2181")
                        .retryPolicy(new ExponentialBackoffRetry(1000,3)).build();

    public static void main(String[] args) throws InterruptedException {
        client.start();
        LeaderSelector selector = new LeaderSelector(client, MASTER_PATH,
                new LeaderSelectorListener() {
                    @Override
                    public void takeLeadership(CuratorFramework curatorFramework) throws Exception {
                        System.out.println("成为Master角色");
                        Thread.sleep(3000);
                        System.out.println("完成Master操作 释放Master权利");
                    }
                    @Override
                    public void stateChanged(CuratorFramework curatorFramework, ConnectionState connectionState) {

                    }
                });
        selector.autoRequeue();
        selector.start();

        Thread.sleep(5000);
    }
}
