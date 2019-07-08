package base.java.springboot;

import org.springframework.stereotype.Component;

/**
 * @author Clay
 * @date 2019/7/8 17:03
 */
@Component
public class TestController {

    String testController () {
        System.out.println("hello");
        return "bye";
    }
}
