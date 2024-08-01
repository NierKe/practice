package com.dk.caffeine;

import com.github.benmanes.caffeine.cache.Cache;

public class CacheTest {
    public static void main(String[] args) {
        Cache<String,Object> instance = CacheUtil.getInstance();
        instance.put("dk","董科");
        Cache<String,Object> instance2 = CacheUtil.getInstance();
        System.out.println(instance2.get("dk",x->{return "hh";}));
    }

}
