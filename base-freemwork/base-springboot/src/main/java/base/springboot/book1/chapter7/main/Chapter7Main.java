package base.springboot.book1.chapter7.main;

import base.springboot.book1.chapter7.config.RedisConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

/**
 * @author tangwei
 * @date 2019/12/17 10:03
 */
public class Chapter7Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RedisConfig.class);
        RedisTemplate redisTemplate  = applicationContext.getBean(RedisTemplate.class);
//        redisTemplate.opsForValue().set("haha","haha1");
//        useRedisCallback(redisTemplate);
        useSessionCallback(redisTemplate);
        System.out.println("====结果是"+ redisTemplate.getExpire("demo1"));
    }


    // 需要处理底层的转换规则，如果不考虑改写底层，尽量不使用它
    public static void useRedisCallback(RedisTemplate redisTemplate) {
        redisTemplate.execute(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.set("demo1".getBytes(), "value1".getBytes());
                redisConnection.hSet("hash".getBytes(), "hashKey1".getBytes(), "value2".getBytes());

                return null;
            }
        });
    }

    // 高级接口，比较友好，一般情况下，优先使用它
    public static void useSessionCallback(RedisTemplate redisTemplate) {
        redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.opsForValue().set("key1","value1");
                redisOperations.opsForHash().put("hash","field","hashValue");
                return null;
            }
        });
    }


}
