package com.dk.equals;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;

public class Test2 {
    public static void main(String[] args) {
//        // 假设这是你的 JSON 字符串
//        String jsonString = "{ \"name\": \"Alice\", \"address\": { \"city\": \"Wonderland\", \"zip\": \"12345\" } }";
//
//        // 将字符串转换为 JSONObject
//        JSONObject jsonObject = JSON.parseObject(jsonString);
//        // 使用 Optional 获取 city 值
//        Optional<String> city = Optional.ofNullable(jsonObject.getJSONObject("address"))
//                .map(address -> address.getString("city"));
        // 打印结果
       // city.ifPresent(System.out::println);
// 给定的年月日
        int year = 2024;
        int month = 3;
        int day = 3;

        // 创建 LocalDate 对象
        LocalDate date = LocalDate.of(year, month, day);

        // 获取该日期所在周的周一
        LocalDate monday = date.with(DayOfWeek.MONDAY);

        // 输出结果
        System.out.println("Given date: " + date);
        System.out.println("Monday of the week: " + monday);

    }
}
