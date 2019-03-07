package com.base.java.spring.aop.cglib;


import com.base.java.spring.aop.base.ForumServiceImpl;

/**
 * @author tangwei
 * @date 2018/12/26 11:03
 */
public class CgProxyTest {

    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        ForumServiceImpl forumService = (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(10);
        forumService.removeTopic(22);
    }
}
