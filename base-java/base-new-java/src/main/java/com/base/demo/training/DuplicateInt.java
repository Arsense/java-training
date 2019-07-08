package com.base.demo.training;

/**
 * @author tangwei
 * @date 2019/6/21 11:15
 */
public class DuplicateInt {

    public static  ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return  head;
        }
        ListNode index1 = head;
        ListNode index2 = head.next;
        //1 ->1 ->1
        while (index2 != null) {
            //不相等直接后移
            if(index1.val != index2.val) {
                index1 = index2;
                index2 = index2.next;
                continue;
            }
            if(index2.next == null) {
                index1.next = null;
                return head;
            }
            index1.next = index2.next;
            index2 = index2.next;
        }


        return head;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);

        //[1,1,2,3,3,4,5,5,5,6,6,6]
        node1.next = node2;
        node2.next = node3;
        ListNode result = deleteDuplicates(node1);
        int  a = 1;
    }

}
