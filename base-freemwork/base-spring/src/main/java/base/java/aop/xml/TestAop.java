package base.java.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author Clay
 * @date 2019/7/8 11:31
 */
public class TestAop {

    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("/base-freemwork/base-spring/src/main/resources/spring-aop.xml");
        TestTarget testTarget = (TestTarget) context.getBean("testAOP");
        testTarget.test();
        System.out.println("--------------------");
        testTarget.test2();


    }
}
