package com.code.life.online.tool.order;

import org.I0Itec.zkclient.exception.ZkMarshallingError;
import org.I0Itec.zkclient.serialize.ZkSerializer;

/**
 * @author Clay
 * @date 2019/5/19 15:23
 */
public class MyZkSerializer implements ZkSerializer {
    @Override
    public byte[] serialize(Object o) throws ZkMarshallingError {
        return new byte[0];
    }

    @Override
    public Object deserialize(byte[] bytes) throws ZkMarshallingError {
        return null;
    }
}
