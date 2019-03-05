package com.base.java.freemwork.proxy;

import com.base.java.freemwork.proxy.UserDao;

/**
 * @author tangwei
 * @date 2019/3/5 17:38
 */
public class UserDaoImpl implements UserDao {

    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
