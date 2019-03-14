package com.test.awmsome.structure;

import com.test.awmsome.structure.base.Node;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * 头插法
 * @author tangwei
 * @date 2019/3/14 10:56
 */
public class LinkList implements AbstarctStructure<String> {

    private Node header;
    private int size;


    @Override
    public void add(String value) {
        if (StringUtils.isEmpty(value)) {
            return;
        }
        if (header == null) {
            header = new Node(value, null);
        } else {
            header = new Node(value, header);
        }
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
        i = size - i;
        while (tempNode != null && (i-- > 1)) {
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
        i = size - i;
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
        if (header == null || i > size) {
            return null;
        }
        Node headTemp = header;
        while(headTemp != null && (i-- > 1)) {
            headTemp = headTemp.next;
        }
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
