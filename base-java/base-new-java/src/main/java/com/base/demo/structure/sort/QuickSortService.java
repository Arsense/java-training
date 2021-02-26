package com.base.demo.structure.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @Author: Clay
 * @Date: 2021/2/26 5:47 下午
 */
public class QuickSortService {

    public static void main(String[] args) {
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        // 只需要修改成对应的方法名就可以了
        quickSort(array);

        System.out.println(Arrays.toString(array));
    }

    /**
     * 快速排序
     * @param array
     */
    private static void quickSort(int[] array) {

    }
}
