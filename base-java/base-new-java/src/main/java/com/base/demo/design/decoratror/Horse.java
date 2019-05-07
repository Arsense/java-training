package com.base.demo.design.decoratror;

/**
 * @author tangwei
 * @date 2019/3/6 15:27
 */
public class Horse extends Change{


    public Horse(TheGreatestSage theGreatestSage) {
        super(theGreatestSage);
    }

    @Override
    public void move() {
        super.move();
        System.out.println("change to horse");
    }
}
