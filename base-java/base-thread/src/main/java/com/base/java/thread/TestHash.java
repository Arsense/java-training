//package com.base.java.thread;
//
//import com.sun.deploy.util.StringUtils;
//
///**
// * @author tangwei
// * @date 2019/4/30 17:41
// */
//public class TestHash {
//    private final static HashAlgorithm hashAlgorithm = HashAlgorithm.KETAMA_HASH;
//
//
//    /**
//     * 通过key值计算数据储存节点
//     *
//     * @param key key
//     * @return 数据节点
//     */
//    public static int getDataNode(Long key) {
//
//        if (key == null) {
//            return -1;
//        }
//        //数据库节点从1开始
//        return JmiRouteUtil.getDataNode(String.valueOf(key));
//
//    }
//
//    /**
//     * 通过key值计算数据储存节点
//     *
//     * @param key key
//     * @return 数据节点
//     */
//    public static int getDataNode(String key) {
//
//        if (StringUtils.isEmpty(key)) {
//            return -1;
//        }
//        //数据库节点从1开始
//        return (int) (hashAlgorithm.hash(key) & ContextConstants.DATA_NODE) + 1;
//    }
//
//    /**
//     * @param key key
//     * @return 表节点位置
//     */
//    public static int getTableNode(String key) {
//
//        if (StringUtils.isEmpty(key)) {
//            return -1;
//        }
//        return (int) (((hashAlgorithm.hash(key) & ContextConstants.TABLE_NODE)) >> 3);
//    }
//
//    /**
//     * @param key key
//     * @return 表节点位置
//     */
//    public static int getTableNode(Long key) {
//
//        if (key == null) {
//            return -1;
//        }
//
//        return JmiRouteUtil.getTableNode(String.valueOf(key));
//
//    }
//
//    private final static long values[] = {0, 1, 2, 6, 8, 11, 14, 15};
//
//    public static void main(String[] args) {
//        JmiRouteUtil jmiRouteUtil = new JmiRouteUtil();
////        for (int i = 0; i < 100; i++) {
////            int code = jmiRouteUtil.getDataNode(values[i]);
////            // int index = jmiRouteUtil.getTableNode(values[i]);
////            System.out.println("i:" + i + "库:" + code + ",表:");
////        }
//        Long key =  200100243605L;
//        int code = jmiRouteUtil.getDataNode(key);
//        int index = jmiRouteUtil.getTableNode(key);
//        System.out.println("i:" + "" + "库:" + code + ",表:" + index);
//
//    }
//}
