package base.java.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  手动加载bean
 * @author Clay
 * @date 2019/3/7 17:44
 */
public class App {
    public static void main(String[] args) {
        // 用我们的配置文件来启动一个 ApplicationContext
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-bean.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-bean.xml");

        System.out.println("context 启动成功");

        // 从 context 中取出我们的 Bean，而不是用 new MessageServiceImpl() 这种方式
        MessageService messageService = context.getBean(MessageService.class);
        // 这句将输出: hello world
        System.out.println(messageService.getMessage());
    }
}
