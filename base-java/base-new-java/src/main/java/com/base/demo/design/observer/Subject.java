package com.base.demo.design.observer;

/** 主题（发布者、被观察者）
 * @author Clay
 * @date 2019/3/6 16:47
 */
public interface Subject {

    public void registerObserver(Observer observer);


    public void removeObserver(Observer observer);


    public void notifyObserver();


}
