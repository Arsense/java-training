package com.base.java.freemwork.decoratror;

/** 包装器
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
