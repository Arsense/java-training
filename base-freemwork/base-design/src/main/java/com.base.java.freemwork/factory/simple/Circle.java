package com.base.java.freemwork.factory.simple;

/**
 * @author tangwei
 * @date 2019/3/5 18:39
 */
public class Circle implements Shape {
    public Circle() {
        System.out.println("Circle");
    }
    @Override
    public void draw() {
        System.out.println("Draw Circle");
    }
}