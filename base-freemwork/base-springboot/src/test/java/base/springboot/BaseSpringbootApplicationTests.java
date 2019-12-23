package base.springboot;

import base.springboot.aopdemo.RollbackService;
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

}
