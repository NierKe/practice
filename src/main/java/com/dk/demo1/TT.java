package com.dk.demo1;

import java.util.*;

public class TT {
    public static void main(String[] args) {
        List<Map<String, String>> resultList = new ArrayList<>();
        Map<String, String> map = new HashMap();
        map.put("cbillno","1111");
        Map<String, String> map2 = new HashMap();
        map2.put("cbillno","1111");
        Map<String, String> map3 = new HashMap();
        map3.put("cbillno","1112");
        Map<String, String> map4 = new HashMap();
        map4.put("cbillno","1112");
        resultList.add(map);
        resultList.add(map2);
        resultList.add(map3);
        resultList.add(map4);
        List<Map<String, String>> maps = removeRepeatData(resultList);
        System.out.println(maps);
    }

    private static List<Map<String, String>> removeRepeatData(List<Map<String, String>> resultList) {
        Map<String,Integer> map = new HashMap();
        Map<String,Map<String, String>> map2 = new HashMap();
        List<Map<String, String>> newList = new ArrayList<>();
        for (int i = 0;i<resultList.size();i++){
            String cbillno = resultList.get(i).get("cbillno");
            if(map.containsKey(cbillno)){
                Integer newNum = map.get(cbillno) + 1;
                map.put(cbillno,newNum);
            }else{
                map.put(cbillno,1);
            }
            map2.put(cbillno,resultList.get(i));
        }
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while(iterator.hasNext()){
            String key =iterator.next();
            if(map.get(key) == 1){
                newList.add(map2.get(key));
            }
        }

        return newList;
    }
}
