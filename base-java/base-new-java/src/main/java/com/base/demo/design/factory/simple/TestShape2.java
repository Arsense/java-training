package com.base.demo.design.factory.simple;

/**
 * @author Clay
 * @date 2019/3/5 19:18
 */
public class TestShape2 {

    public static void main(String[] args) {
         Circle circle = (Circle) ShapeFactoryReflect.getShape(Circle.class);
         circle.draw();

         Square square = (Square) ShapeFactoryReflect.getShape(Square.class);
         square.draw();
         Rectangle rectangle = (Rectangle) ShapeFactoryReflect.getShape(Rectangle.class);
         rectangle.draw();


    }
}
