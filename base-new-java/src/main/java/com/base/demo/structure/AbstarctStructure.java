package com.base.demo.structure;

/**
 * @author tangwei
 * @date 2019/3/14 10:49
 */
public interface AbstarctStructure<T> {
    /*
       增
     */
    public void add(T value);
    /*
       指定位置删除
     */
    public void remove(int i);
    /*
       指定位置插入
     */
    public void insert(int i,T value);
    /*
       查
     */
    public T query(int i);

    /**
     * 输出信息
     */
    public void print();



}
