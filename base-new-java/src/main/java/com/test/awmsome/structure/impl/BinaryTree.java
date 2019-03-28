package com.test.awmsome.structure.impl;

import com.test.awmsome.structure.AbstarctStructure;
import com.test.awmsome.structure.base.Node;
import com.test.awmsome.structure.base.TreeNode;

/**
 *  二叉树
 *
 * @author tangwei
 * @date 2019/3/15 9:30
 */
public class BinaryTree implements AbstarctStructure{
    int depth;
    public TreeNode root;

    public BinaryTree() {
        this.depth = 0;
        this.root = null;
    }


    @Override
    public void add(Object value) {

    }

    @Override
    public void insert(int i, Object value) {
    }

    /**
     * 插入树中  比跟节点大的右插 小的左插
     * @param value
     */
    public void insert(int value) {
        TreeNode node = new TreeNode(value);
        if (root == null) {
            root = node;
            return;
        } else {
            TreeNode  current = root;
            while (true) {
                if (value > current.value) {
                    if (current.rightNode == null) {
                        current.rightNode = node;
                        return;
                    }
                    current = current.rightNode;
                }
                if (value < current.value) {
                    if (current.leftNode == null) {
                        current.leftNode = node;
                        return;
                    }
                    current = current.leftNode;
                }
            }
        }
    }

    public void  buildTree(int[] data) {
        for (int i = 0; i < data.length;i++) {
            insert(data[i]);
        }
    }

    /**
     * 前序遍历
     */
    public void beforeList() {
        System.out.println("前序遍历============");
        beforeList(root);
    }

    public void beforeList(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.value + ",");
        beforeList(node.leftNode);
        beforeList(node.rightNode);
    }

    /**  左根右
     * 中序遍历
     */
    public void middleList() {
        System.out.println("中序遍历============");
        middlerOrder(root);
    }

    public void middlerOrder(TreeNode node) {
        if (node == null) {
            return;
        } else {
            middlerOrder(node.leftNode);
        }
        System.out.print(node.value);
        middlerOrder(node.rightNode);
    }

    /**
     * 后序遍历
     */
    public void afterList() {
        System.out.println("后序遍历============");
        afterOrder(root);
    }

    public void afterOrder(TreeNode node) {
        if (node == null) {
            return;
        } else {
            middlerOrder(node.leftNode);
            middlerOrder(node.rightNode);
        }
        System.out.print(node.value);
    }


    @Override
    public Object query(int i) {
        return null;
    }

    @Override
    public void print() {

    }


    @Override
    public void remove(int i) {

    }
}
