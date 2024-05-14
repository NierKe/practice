package com.dk.jedis;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestXT {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        JSONObject ob = new JSONObject();
        ob.put("hello","world");
        ob.put("name","dk");
        Transaction multi = jedis.multi();
        String jsonString = ob.toJSONString();
        try {
            multi.set("user1",jsonString);
            multi.set("user2",jsonString);
            multi.exec();//执行事务
        }catch (Exception e){
            multi.discard();//放弃事务
            e.printStackTrace();
        }
        finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();
        }
    }
}
