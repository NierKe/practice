package com.dk.demo1.controller;


import com.alibaba.fastjson.JSONObject;
import com.dk.demo1.pojo.User;

import com.dk.demo1.service.IUserService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *董科测试
 * @author jobob
 * @since 2023-10-10
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @Value("${pk_group.pk_org.pk_dept.user_id}")
    private String value;
    @Autowired
    private Environment environmentConfig;

    @Autowired
    private StudentConfig student;

    @Autowired
    private YmlRead read;
    @RequestMapping(value="/add", method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody User user){
//        User user = new User();
//        user.setNickname("dk");
//        user.setPassword("12312");
//        user.setSalt("qweqwe");
//        user.setHead("sdasda");
//        user.setLoginCount(100);
        userService.add(user);
        System.out.println(user.getId());
    }


    @RequestMapping(value="/test", method = RequestMethod.POST)
    @ResponseBody
    public void test(@RequestBody String str){

        System.out.println(str);
    }

    @RequestMapping(value="/test3", method = RequestMethod.POST)
    @ResponseBody
    public void test3(@RequestParam(value="str",required = true) String str){
       // System.out.println(str);
       // System.out.println(value);
//        String property = environmentConfig.getProperty("pk_group.pk_org.pk_dept.user_id");
//        System.out.println(property);

        System.out.println(read.user_id);

    }

    @RequestMapping(value="/test2/{name}/{age}", method = RequestMethod.POST)
    @ResponseBody
    public void test2(@PathVariable String name,@PathVariable int age){

        System.out.println("name:"+name+"age:"+age);
    }


    @RequestMapping(value="/test4", method = RequestMethod.POST)
    @ResponseBody
    public void test4(@RequestBody List<String> list){
        List<User> userList = userService.queryBatch(list);
        System.out.println(Arrays.toString(userList.toArray()));

    }

    @RequestMapping(value="/test5", method = RequestMethod.POST)
    @ResponseBody
    public  ResponseEntity<List<User>> test5(@RequestBody User user){
        List<User> users = userService.queryUsers(user);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        return new ResponseEntity<>(users, headers, HttpStatus.OK);

    }
}
