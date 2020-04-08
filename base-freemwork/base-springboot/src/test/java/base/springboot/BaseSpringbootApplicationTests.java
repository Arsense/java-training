package base.springboot;

import base.springboot.aopdemo.RollbackService;
import base.springboot.controller.RequestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseSpringbootApplicationTests {


	@Resource
	private RollbackService rollbackService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test (){
		rollbackService.saveList();
	}


	@Test
	public void testConfig(){
		String config1 = RequestHelper.getConfig1();
		String config2 = RequestHelper.getConfig1();

		System.out.println("config1是:" + config1);
		System.out.println("config2是:" + config2);

	}
}
