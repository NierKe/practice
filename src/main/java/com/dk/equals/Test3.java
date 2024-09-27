package com.dk.equals;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test3 {
    public static void main(String[] args) {
//        StudentVO stu1 = new StudentVO(1,11,"boy",null,null,"张三");
//        StudentVO stu2 = new StudentVO(2,12,"girl",null,null,"李四");
//        StudentVO stu3 = new StudentVO(3,12,"boy",null,null,"王五");
//        StudentVO stu4 = new StudentVO(4,11,"boy",null,null,"赵六");
//        StudentVO stu5 = new StudentVO(5,13,"girl",null,null,"马云");
//        List<StudentVO> studentVOS = Arrays.asList(stu1, stu2, stu3, stu4, stu5);
//        Map<String, List<StudentVO>> collect = studentVOS.stream().collect(Collectors.groupingBy(StudentVO::getSex));
//        Map<String, List<StudentVO>> collect1 = studentVOS.stream().collect(Collectors.groupingBy(item -> item.getSex() + "_" + item.getAge()));
//        System.out.println(collect);
//        System.out.println(collect1);


        String jsonStr =  "{\"data\":[{\"name\": \"John\", \"age\": 30}, {\"name\": \"Jane\", \"age\": 25}]}";
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        List<JSONObject> collect = jsonObject.getJSONArray("data").stream().map(x -> {
            JSONObject json = (JSONObject) x;
            json.put("dd", "dk");
            return json;
        }).collect(Collectors.toList());
        System.out.println(collect);
    }
}
