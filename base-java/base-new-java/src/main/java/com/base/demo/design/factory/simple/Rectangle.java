package com.base.demo.design.factory.simple;

/**
 * @author tangwei
 * @date 2019/3/5 18:39
 */

public class Rectangle implements Shape {
    public Rectangle() {
        System.out.println("Rectangle");
    }
    @Override
    public void draw() {
        System.out.println("Draw Rectangle");
    }
}
