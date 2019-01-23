package com.base.java.jvm.gctest.out.memory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *  -VM 参数 -Xms20m -Xmx20m -XX:+HeapDumpOnOutofMemoryError
 * @author tangwei
 * @date 2019/1/22 18:36
 */
public class HeapOOM {


    static class OOMObject{

    }
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
