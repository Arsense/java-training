package com.base.java.freemwork.decoratror;

/**
 * @author tangwei
 * @date 2019/3/6 15:28
 */
public class Test {
    public static void main(String[] args) {
       TheGreatestSage sage = new Money();

       TheGreatestSage fish = new Fish(sage);
       fish.move();
       TheGreatestSage horse = new Horse(sage);
       horse.move();
    }
}
