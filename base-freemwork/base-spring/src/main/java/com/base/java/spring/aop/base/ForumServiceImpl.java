package com.base.java.spring.aop.base;

/**
 * @author tangwei
 * @date 2018/12/26 9:47
 */
public class ForumServiceImpl implements ForumService {

    @Override
    public void removeForum(int topicId) {
//        PerformanceMonitor.begin("com.spring.demo.aop.removeForum");
        System.out.println("模拟删除Topic记录" + topicId);
        try {
            Thread.sleep(20);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        PerformanceMonitor.end();
    }

    @Override
    public void removeTopic(int forumId) {
//        PerformanceMonitor.begin("com.spring.demo.aop.removeTopic");
        System.out.println("模拟删除Forum记录" + forumId);
        try {
            Thread.sleep(40);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        PerformanceMonitor.end();


    }
}
