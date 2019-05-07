package com.base.demo.design.proxy.dynamic.cglib;

/**
 * @author tangwei
 * @date 2019/3/5 18:08
 */
public class App2 {

    public static void main(String[] args) {
        //目标对象
        UserDaoChild target = new UserDaoChild();

        //代理对象
        UserDaoChild proxy = (UserDaoChild)new CglibProxyFactory(target).getProxyInstance();

        //执行代理对象的方法
        proxy.save();
    }
}
