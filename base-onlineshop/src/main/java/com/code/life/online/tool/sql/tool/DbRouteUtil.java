package com.code.life.online.tool.sql.tool;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * 分库分表工具
 * @author tangwei
 * @date 2019/5/27 15:42
 */
public class DbRouteUtil {


    private final static HashAlgorithm hashAlgorithm = HashAlgorithm.KETAMA_HASH;
    /**
     * 目前的存储节点 8个 从0开始 如果是2的n次幂 直接&运算 (效率比取余高)
     * 如果此值修改为noteCode+1 不是2的n次幂 则需要将&运算 修改为 % 取余运算
     */
    //public static final int DATA_NODE = 7;
    public static final int DATA_NODE = 0x07;

    /**
     * 数据库表数量
     */
    //public static final int TABLE_NODE = 15;
    public static final int TABLE_NODE = 0x78;

    public static void main(String[] args) {
        DbRouteUtil util = new DbRouteUtil();

        Long key =  123L;
        int code = DbRouteUtil.getDataSourceNode(key);
        int index = DbRouteUtil.getTableNode(key);
        System.out.println("i:" + "" + "库:" + code + ",表:" + index);
    }

    public static int getDataSourceNode(Long key) {

        if (key == null) {
            return -1;
        }
        //数据库节点从1开始
        return DbRouteUtil.getDataNode(String.valueOf(key));

    }

    /**
     * 通过key值计算数据储存节点
     *
     * @param key key
     * @return 数据节点
     */
    public static int getDataNode(String key) {

        if (StringUtils.isEmpty(key)) {
            return -1;
        }
        //数据库节点从1开始
        return (int) (hashAlgorithm.hash(key) & DATA_NODE) + 1;
    }

    /**
     * @param key key
     * @return 表节点位置
     */
    public static int getTableNode(Long key) {

        if (key == null) {
            return -1;
        }

        return DbRouteUtil.getTableNode(String.valueOf(key));

    }

    /**
     * @param key key
     * @return 表节点位置
     */
    public static int getTableNode(String key) {

        if (StringUtils.isEmpty(key)) {
            return -1;
        }
        return (int) (((hashAlgorithm.hash(key) & TABLE_NODE)) >> 3);
    }
}
