package base.springboot.book1.chapter7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;
/**
 * @author Clay
 * @date 2019/12/23 9:54
 */
@Controller
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate = null;

    @RequestMapping("/lua")
    @ResponseBody
    public Map<String, Object> testLua() {

        DefaultRedisScript<String> rs = new DefaultRedisScript<String>();
        // 设置脚本
        rs.setScriptText("return 'Hello Redis'");
        // 定义返回类型，注意如果没有这个定义Spring不会返回结果
        rs.setResultType(String.class);
        RedisSerializer<String> stringSerializer = redisTemplate.getStringSerializer();

        // 执行Lua脚本
        String str = (String) redisTemplate.execute(rs, stringSerializer, stringSerializer, null);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("str", str);
        return map;

    }
    @RequestMapping("/lua2")
    @ResponseBody
    public Map<String, Object> testLua2() {
// 定义Lua脚本

        String key1 = "luaKey1";
        String key2 = "luaKey2";
        String value1 = "luaValue1";
        String value2 = "luaValue2";
        String lua = " redis.call('set', KEYS[1], ARGV[1]) \n"
                + " redis.call('set', KEYS[2], ARGV[2]) \n"
                + " local str1 = redis.call('get', KEYS[1]) \n"
                + " local str2 = redis.call('get', KEYS[2]) \n"
                + " if str1 == str2 then  \n" + "return 1 \n"
                + " end \n"
                + " return 0 \n";
        System.out.println(lua);
        // 结果返回为Long
        DefaultRedisScript<Long> rs = new DefaultRedisScript<Long>();
        rs.setScriptText(lua);
        rs.setResultType(Long.class);
        // 采用字符串序列化器
        RedisSerializer<String> stringSerializer = redisTemplate.getStringSerializer();
        // 定义key参数
        List<String> keyList = new ArrayList<>();
        keyList.add(key1);
        keyList.add(key2);
        // 传递两个参数值，其中第一个序列化器是key的序列化器，第二个序列化器是参数的序列化器
        Long result = (Long) redisTemplate.execute(rs, stringSerializer, stringSerializer, keyList, value1, value2);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", result);
        return map;


    }
}
