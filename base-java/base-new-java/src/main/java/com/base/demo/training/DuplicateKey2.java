package com.base.demo.training;

import org.springframework.util.Assert;

/**
 * @author Clay
 * @date 2019/6/21 14:50
 */
public class DuplicateKey2 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int index = 2;
        for(int i = 2;i < nums.length;i++) {
            if(nums[i] != nums[index-2]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
//        int nums[] = {1, 1, 2, 2, 2, 3};
//        System.out.println("最后长度是:" + removeDuplicates(nums));
//        4,5,6,7,0,1,2
        int nums[] = {4,5,6,7,0,1,2};
        Assert.isTrue(4 == search(nums,4));
        int a = 1;
    }

    public static  int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1 ) {
            return nums[0] == target?0:-1;
        }
        //二分查找
        int head = 0;
        int tail = nums.length;
        while (head != tail) {
            int mid = (tail - head) / 2 + head;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[head]){
                //要确认小的在哪边
                if (nums[mid] > target && nums[head] <= target) {
                    tail = mid ;
                } else {
                    head = mid + 1;
                }

            } else {
                if (nums[mid] < target && nums[tail-1] >= target) {
                    head = mid + 1;
                } else {
                    tail = mid;
                }
            }
        }
        return -1;

    }
}
