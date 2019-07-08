package com.base.demo.design.proxy;

import com.base.demo.design.proxy.UserDao;

/**
 * @author Clay
 * @date 2019/3/5 17:38
 */
public class UserDaoImpl implements UserDao {

    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
