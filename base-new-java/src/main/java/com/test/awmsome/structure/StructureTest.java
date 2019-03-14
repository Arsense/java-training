package com.test.awmsome.structure;

/**
 * @author tangwei
 * @date 2019/3/14 10:56
 */
public class StructureTest {

    public static void main(String[] args) {
        LinkList list = new LinkList();

        list.add("第一个元素");
        list.add("第二个元素");
        list.add("第3个元素");
        list.add("第4个元素");
        System.out.println("第一次结果为:");
        list.print();

        list.insert(1,"插入值");
        System.out.println("第2次结果为:");
        list.print();

        list.remove(1);
        System.out.println("第3次结果为:");
        list.print();

    }
}
