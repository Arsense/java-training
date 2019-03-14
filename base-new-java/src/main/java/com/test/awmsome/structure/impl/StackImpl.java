package com.test.awmsome.structure.impl;

import com.test.awmsome.structure.Stack;

/**
 *
 * 其实就是一个对象数据
 * @author tangwei
 * @date 2019/3/14 10:48
 */
public class StackImpl<T> implements Stack<String> {

    //目前存储大小
    private int size = 0;
    //栈顶元素位置
    private int top = -1;

    private T[] array;

    private int defaultSize = 10;

    public StackImpl(int size) {
        this.array = (T[])new Object[size];
    }
    public StackImpl(){
        this.array = (T[])new Object[defaultSize];
    }


    @Override
    public void push(String data) {
        if(array.length <= size) {
            //扩容
        }
        array[++top] = (T) data;
        size++;
    }

    /**
     * 返回栈顶元素,未出栈
     * @return
     */
    @Override
    public String peek() {
        if(size <= 0) {
            return null;
        }
        return (String) array[top];
    }

    /**
     * 出栈,返回栈顶元素,同时从栈中移除该元素
     * @return
     */
    @Override
    public String pop() {
        if(size <= 0) {
            return null;
        }
        size --;
        return (String) array[top--];
    }


    public void print(){
        int i = 0;
        while (i < size) {
            System.out.println(array[i]);
            i++;
        }
    }
}
