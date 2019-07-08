package base.java.aop.proxy.cglib;


import base.java.aop.base.ForumServiceImpl;

/**
 * @author Clay
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
