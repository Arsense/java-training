package com.base.demo.design.factory.simple;

/**
 * @author Clay
 * @date 2019/3/5 18:39
 */
public class Square implements Shape {
    public Square() {
        System.out.println("Square");
    }

    @Override
    public void draw() {
        System.out.println("Draw Square");
    }
}