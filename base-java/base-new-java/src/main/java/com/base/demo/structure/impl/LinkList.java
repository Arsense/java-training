package com.base.demo.structure.impl;

import com.base.demo.structure.AbstarctStructure;
import com.base.demo.structure.base.Node;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * 头插法
 * @author Clay
 * @date 2019/3/14 10:56
 */
public class LinkList implements AbstarctStructure<String> {

    private Node header;
    private int size;
    private Node tail;


    LinkList (){
        size = 0;
        header = tail = new Node(null,null);
    }

    @Override
    public void add(String value) {
        if (StringUtils.isEmpty(value)) {
            return;
        }
        Node node = new Node(value, null);
        tail.next = node;
        tail = node;
        node.next = null;
        size++;
    }

    /**
     *  尾节点删除  照理说返回删除值比较科学
     */
    @Override
    public void remove(int i) {
        if (header.next == null) {
            return;
        }
        Node tempNode = header;
        while (tempNode != null && (i-- > 0)) {
            tempNode = tempNode.next;
        }
        size--;
    }

    @Override
    public void insert(int i, String value) {
        if (header == null || i > size) {
            return;
        }
        Node headTemp = header;
        while(headTemp != null && (i-- > 1)) {
            headTemp = headTemp.next;
        }
        Node tempNode = new Node(value, headTemp);
        tempNode.next = headTemp.next;
        headTemp.next = tempNode;
        size++;
    }


    @Override
    public String query(int i) {
        int queryId = i;
        if (header == null || i > size) {
            return null;
        }
        Node headTemp = header;
        while(headTemp != null && (i-- > 0)) {
            headTemp = headTemp.next;
        }
        System.out.println("查询元素:" + queryId + "结果为:" + headTemp.value);
        return (String) headTemp.value;
    }

    @Override
    public void print() {
        if (size <= 0) {
            return;
        }
        Node tempNode = header;
        while (tempNode != null) {
            System.out.println(tempNode.value);
            tempNode = tempNode.next;
        }
    }

}
