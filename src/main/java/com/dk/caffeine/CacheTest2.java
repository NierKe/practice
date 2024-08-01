package com.dk.caffeine;

import com.github.benmanes.caffeine.cache.Cache;

public class CacheTest2 {
    public static void main(String[] args) {
        Cache<String, Object> instance = CacheUtil.getInstance();
        Object dk = instance.get("dk", x -> {
            return "hh";
        });
        System.out.println(dk);
    }
}
