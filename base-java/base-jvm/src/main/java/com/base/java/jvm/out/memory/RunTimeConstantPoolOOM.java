package com.base.java.jvm.out.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 设置常量池的大小 -XX:PermSize=10M -XX:MaxPermSize=10M
 * @author Clay
 * @date 2019/1/23 11:16
 */
public class RunTimeConstantPoolOOM {

    public static void main(String[] args) {
        //使用List保持对常量池的引用 避免Full GC回收常量池的行为
        List<String> list = new ArrayList<String>();

        int i = 0;
        while(true) {
            list.add(String.valueOf(i++).intern());
        }

    }
}
