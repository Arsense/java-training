package com.base.java.spring.aop.base;


/**
 * @author tangwei
 * @date 2018/12/26 10:11
 */
public class TestForumService {

    public static void main(String[] args) {
        ForumService forumService = new ForumServiceImpl();
        forumService.removeForum(10);
        forumService.removeTopic(1102);
    }
}
