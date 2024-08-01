package com.dk.caffeine;

import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

public class CacheUtil {
    private CacheUtil(){};
    private volatile static com.github.benmanes.caffeine.cache.Cache<String,Object> caffeineCache = null;
    public static com.github.benmanes.caffeine.cache.Cache<String,Object> getInstance(){
        if(caffeineCache == null){
            synchronized (CacheUtil.class){
                caffeineCache = Caffeine.newBuilder()
                        .initialCapacity(500)//整数，表示能存储多少个缓存对象。
                        .maximumSize(500)
                        .expireAfterAccess(5, TimeUnit.MINUTES)
                        .expireAfterWrite(10,TimeUnit.MINUTES)
                        .build();
                return  caffeineCache;
            }
        }
        return caffeineCache;
    };
}
