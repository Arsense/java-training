package com.base.demo.jdk;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *  粘贴代码是为了更懂
 * @author tangwei
 * @date 2019/7/15 17:31
 */
public class MyArrrayList<E> extends AbstractList<E> implements List<E> {

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     *存储arraylist元素的数组缓冲区。
     *arraylist的容量是这个数组缓冲区的长度。任何
     *带有elementdata==defaultcapacity_empty_elementdata的空arraylist
     *将在添加第一个元素时扩展为默认容量。
     * //非私有以简化嵌套类访问   transient不参与序列化
     */
    transient Object[] elementData;
    //实际空间存储大小
    private int size;

    /**
     * 构造初始容量为10的空列表。
     */
    public MyArrrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public MyArrrayList(int initialCapacity){
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }
    /**  集合之间的复制吧
     *构造包含指定的
     *集合，按照集合的返回顺序
     *迭代器。
     *
     */
    public MyArrrayList(Collection<? extends E> c) {
        elementData = c.toArray();
        if ((size = elementData.length) != 0) {
            // c.toArray might (incorrectly) not return Object[] (see 6260652)
            if (elementData.getClass() != Object[].class) {
                elementData = Arrays.copyOf(elementData, size, Object[].class);
            }
        } else {
            // replace with empty array.
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    @Override
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;

    }

    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }



    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }


    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;


    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        // overflow-conscious code  扩容
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        // 如果新容量发现比需要的容量还小，则以需要的容量为准
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        // 如果新容量已经超过最大容量了，则使用最大容量
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // 以新容量拷贝出来一个新数组
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

        @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    public static void main(String[] args) {

    }

}
