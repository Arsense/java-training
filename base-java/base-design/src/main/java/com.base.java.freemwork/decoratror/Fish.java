package com.base.java.freemwork.decoratror;

/**
 * @author tangwei
 * @date 2019/3/6 15:27
 */
public class Fish extends Change{

    public Fish(TheGreatestSage sage) {
        super(sage);
    }

    @Override
    public void move() {
        super.move();
        System.out.println("change to fish");
    }
}
