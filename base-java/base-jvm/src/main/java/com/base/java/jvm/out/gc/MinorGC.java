package com.base.java.jvm.out.gc;

/**
 * VM参数: -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *  测试
 *
 * @author tangwei
 * @date 2019/1/23 14:18
 */
public class MinorGC {

    private static final int _1MB = 1024*1024;

    /**
     * 新生代MinorGC
     */
    public static void testAllocation() {
        byte[] allocaton1,allocaton2,allocaton3,allocaton4;
        allocaton1 = new byte[2*_1MB];
        allocaton2 = new byte[2*_1MB];
        allocaton3 = new byte[2*_1MB];
        allocaton4 = new byte[4*_1MB];  //到10MB了
    }

    /** 额外添加
     *  -XX: PretenureSizeThreshold = 3145728
     */
    public static void testPretenureSizeThresOld() {
        byte[] allocation;
        allocation = new byte[4*_1MB];
    }


    public static void main(String[] args) {
//        testAllocation();
        testPretenureSizeThresOld(); //大对象直接进入老年代
    }

}
