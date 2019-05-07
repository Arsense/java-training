package com.base.demo.design.decoratror;

/** 包装器  设计模式的包
 * @author tangwei
 * @date 2019/3/6 15:26
        */
public class Change implements TheGreatestSage {
    private TheGreatestSage theGreatestSage;

    public Change(TheGreatestSage theGreatestSage) {
        this.theGreatestSage = theGreatestSage;
    }

    @Override
    public void move() {
        this.theGreatestSage.move();
    }
}
