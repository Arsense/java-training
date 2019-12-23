package base.springboot.book1.chapter7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Clay
 * @date 2019/12/17 9:34
 */
@Configuration
public class RedisConfig {

    private RedisConnectionFactory redisConnectionFactory = null;

    @Bean
    public RedisConnectionFactory initRedisConnectionFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //最大空闲数
        poolConfig.setMaxIdle(30);
        //最大连接数
        poolConfig.setMaxTotal(50);
        //最大等待毫秒数
        poolConfig.setMaxWaitMillis(2000);
        //创建jedis连接工厂
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory(poolConfig);
        //获取单机的Redis配置
        RedisStandaloneConfiguration configuration = connectionFactory.getStandaloneConfiguration();
        configuration.setHostName("127.0.0.1");
        configuration.setPort(6379);
//        configuration.setPassword();#我的没有密码
        this.redisConnectionFactory = connectionFactory;
        return connectionFactory;
    }


    @Bean
    public RedisTemplate<Object, Object> initRedisTemplate() {

        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();

        //获取初始化StringRedisSerializer RedisTemplate会自动初始化
        RedisSerializer stringRedisSerializer = redisTemplate.getStringSerializer();
        //通过设置字符串序列化处理器 使其能够处理序列化
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(stringRedisSerializer);
        redisTemplate.setConnectionFactory(initRedisConnectionFactory());
        return redisTemplate;

    }


}
