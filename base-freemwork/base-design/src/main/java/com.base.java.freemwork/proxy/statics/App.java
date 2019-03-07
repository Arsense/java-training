package com.base.java.freemwork.proxy.statics;

import com.base.java.freemwork.proxy.UserDao;
import com.base.java.freemwork.proxy.UserDaoImpl;

/**<pre>
 *      静态代理demo
 * <pre/>
 * @author tangwei
 * @date 2019/3/5 17:41
 */
public class App {

    public static void main(String[] args) {
        //目标对象
        UserDao userDao = new UserDaoImpl();
        //代理对象,把目标对象传给代理对象,建立代理关系
        UserDaoProxy proxy = new UserDaoProxy(userDao);
        //执行的是代理的方法
        proxy.save();
    }
}
