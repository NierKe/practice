package com.dk.redis;

import com.dk.redis.utils.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.data.redis.core.RedisTemplate;
import pojo.User;

@SpringBootTest
class RedisApplicationTests {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    RedisUtil redisUtil;
    @Test
    void contextLoads() {

        //opsForValue 操作字符串
        //opsForList 操作list
        //opsForSet
        //opsForHash
        //opsForZSet

        //获取redis的连接对象
        //RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
       // connection.flushDb();
        //connection.flushAll();
        redisTemplate.opsForValue().set("name","dk");
        System.out.println(redisTemplate.opsForValue().get("name"));

    }
    @Test
    void test() throws JsonProcessingException {
        User dk = new User("dk", 29);
       // String jsonUser = new ObjectMapper().writeValueAsString(dk);
        redisTemplate.opsForValue().set("user",dk);
        System.out.println(redisTemplate.opsForValue().get("user"));

    }
    @Test
    void test2(){
        redisUtil.set("name","kuangshen");
        System.out.println(redisUtil.get("name"));
    }

}
