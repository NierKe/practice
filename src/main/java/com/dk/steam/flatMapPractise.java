package com.dk.steam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class flatMapPractise {
    public static void main(String[] args) {
        String str = "[{\"age\":33,\"books\":[{\"category\":\"哲学,爱情\",\"id\":1,\"intro\":\"用一把刀划分了爱恨\",\"name\":\"刀的两侧是光明与黑暗\",\"score\":88},{\"category\":\"个人成长,爱情\",\"id\":2,\"intro\":\"讲述如何从失败中明悟真理\",\"name\":\"一个人不能死在同一把刀下\",\"score\":99}],\"id\":1,\"intro\":\"一个从菜刀中明悟哲理的祖安人\",\"name\":\"蒙多\"},{\"age\":15,\"books\":[{\"category\":\"哲学\",\"id\":3,\"intro\":\"带你用思维去领略世界的尽头\",\"name\":\"那风吹不到的地方\",\"score\":85},{\"category\":\"哲学\",\"id\":3,\"intro\":\"带你用思维去领略世界的尽头\",\"name\":\"那风吹不到的地方\",\"score\":85},{\"category\":\"爱情,个人传记\",\"id\":4,\"intro\":\"一个哲学家的恋爱观注定很难把他所在的时代理解\",\"name\":\"吹或不吹\",\"score\":56}],\"id\":2,\"intro\":\"狂风也追逐不上他的思考速度\",\"name\":\"亚拉索\"},{\"age\":14,\"books\":[{\"category\":\"爱情\",\"id\":5,\"intro\":\"无法想象一个武者能对他的伴侣这么的宽容\",\"name\":\"你的剑就是我的剑\",\"score\":56},{\"category\":\"个人传记\",\"id\":6,\"intro\":\"两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢?\",\"name\":\"风与剑\",\"score\":100},{\"category\":\"个人传记\",\"id\":6,\"intro\":\"两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢?\",\"name\":\"风与剑\",\"score\":100}],\"id\":3,\"intro\":\"是这个世界在限制他的思维\",\"name\":\"易\"},{\"age\":14,\"books\":[{\"category\":\"爱情\",\"id\":5,\"intro\":\"无法想象一个武者能对他的伴侣这么的宽容\",\"name\":\"你的剑就是我的剑\",\"score\":56},{\"category\":\"个人传记\",\"id\":6,\"intro\":\"两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢?\",\"name\":\"风与剑\",\"score\":100},{\"category\":\"个人传记\",\"id\":6,\"intro\":\"两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢?\",\"name\":\"风与剑\",\"score\":100}],\"id\":3,\"intro\":\"是这个世界在限制他的思维\",\"name\":\"易\"}]";
        JSONArray jsonArray = JSON.parseArray(str);
        List<String> collect = jsonArray.stream()
                .flatMap(auther -> {
                    return JSON.parseObject(auther.toString()).getJSONArray("books").stream();
                })
                .distinct()
                .flatMap(book -> {
                    return Arrays.stream(JSON.parseObject(book.toString()).getString("category").split(","));
                })
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);

    }
}
