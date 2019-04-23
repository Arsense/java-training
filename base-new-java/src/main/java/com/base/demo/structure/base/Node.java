package com.base.demo.structure.base;

/**
 * 单链表节点
 *
 * @author tangwei
 * @date 2019/3/14 11:04
 */
public class Node {

    /**
     * 节点的值
     */
    public Object value;
    /**
     * 下一个元素
     */
    public Node next;

    public Node(Object nodeValue, Node nextNode) {
        this.value = nodeValue;
        this.next = nextNode;
    }





}
