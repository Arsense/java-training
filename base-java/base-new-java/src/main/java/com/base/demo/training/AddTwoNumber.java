package com.base.demo.training;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tangwei
 * @date 2019/6/24 13:46
 */
public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        //放返回结果
        //先后的顺序不一样 有先后遍历完节点的
        while (node2 != null) {
            if (node2.val > node1.val) {
                if (node1.next == null) {
                    //插入 结束

                }
                if ( node1.next.val < node2.val) {
                    node2 = node2.next;
                }
            } else {
                //前插 下一个


            }
        }

        return node1;
    }
//    Given nums = [2, 7, 11, 15], target = 9,

    /**
     *
       Two Sum
     * @param nums
     * @param target
     * @return
     */
    public  static int[] twoSum(int[] nums, int target) {
        //2分法会比较快
        if (nums.length < 2) {
            return null;
        }

        int length = nums.length;
        for (int i = 0; i <= length-2 ;i++) {
            for (int j = i+1; j <= length -1; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }


    /**
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        Map<Character,Integer> ruleMap = new HashMap<>();
        ruleMap.put('I', 1);
        ruleMap.put('V', 5);
        ruleMap.put('X', 10);
        ruleMap.put('L', 50);
        ruleMap.put('C', 100);
        ruleMap.put('D', 500);
        ruleMap.put('M', 1000);
        int result = 0;
        char[] roman = s.toCharArray();
        for (int i = 0; i < roman.length;i++) {
            if (i == roman.length - 1) {
                result += ruleMap.get(roman[i]);
                return result;
            }
            if (roman[i]== 'I' && (roman[i+1] =='V' ||  roman[i+1] =='X')) {
                result -= 1;
                result += ruleMap.get(roman[i+1]);
                i++;
            } else if (roman[i]== 'X' && (roman[i+1] =='L' ||  roman[i+1] =='C')) {
                result -= 10;
                result += ruleMap.get(roman[i+1]);
                i++;
            } else if (roman[i]== 'C' && (roman[i+1] =='D' ||  roman[i+1] =='M')) {
                result -= 100;
                result += ruleMap.get(roman[i+1]);
                i++;
            }  else {
                result += ruleMap.get(roman[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {3,2,4};
//        System.out.println("结果是:" + Arrays.toString(twoSum(nums, 6)));
        String romax = "IV";
        System.out.println("罗马数为:" +  romanToInt(romax));
    }
}
