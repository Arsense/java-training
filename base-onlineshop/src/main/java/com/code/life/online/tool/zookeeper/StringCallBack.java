package com.code.life.online.tool.zookeeper;

import org.apache.zookeeper.AsyncCallback;

/**
 * @author tangwei
 * @date 2019/6/19 18:22
 */
public class StringCallBack implements AsyncCallback.StringCallback{
    @Override
    public void processResult(int i, String path, Object context, String name) {
        System.out.println("创建节点 path " + path + "name " + name + "context " + context) ;
    }
}
