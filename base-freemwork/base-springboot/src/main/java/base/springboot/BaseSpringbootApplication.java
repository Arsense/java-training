package base.springboot;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = "base.springboot.book1")
@MapperScan(basePackages = "base.springboot.book1", annotationClass = Mapper.class)
@EnableCaching
public class BaseSpringbootApplication {

	@Autowired
	private RedisTemplate redisTemplate = null;
	//定义自定义后初始化方法
	@PostConstruct
	public void init() {
		initRedisTemplate();
	}

	/**
	 * 设置RedisTemplate初始化的序列器
	 */
	private void initRedisTemplate() {
		RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
		redisTemplate.setKeySerializer(stringSerializer);
		redisTemplate.setHashKeySerializer(stringSerializer);

	}

	public static void main(String[] args) {
		SpringApplication.run(BaseSpringbootApplication.class, args);
	}

}
