package com.base.demo.structure;

/**
 * @author Clay
 * @date 2019/3/14 17:20
 */
public interface Stack<T> {

    /**
     * data元素入栈
     * @param data
     */
    void push(T data);

    /**
     * 返回栈顶元素,未出栈
     * @return
     */
    T peek();

    /**
     * 出栈,返回栈顶元素,同时从栈中移除该元素
     * @return
     */
    T pop();

}
