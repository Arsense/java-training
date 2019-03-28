package com.base.java.jvm;

/**
 *  有点累
 * @author tangwei
 * @date 2019/3/27 20:37
 */
public class ShowSpaceDemo {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
          // 1/4 3736076288  3.48G
        System.out.println("最大内存为:" + runtime.maxMemory()/1024/1024 + "MB");
        //1/64  253231104
        System.out.println("TOTAL内存为:" + runtime.totalMemory()/1024/1024 + "MB");

    }
}
