package com.dk.proxy;

public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("实现了新增方法！");
    }

    @Override
    public void delete() {
        System.out.println("实现了删除方法！");
    }

    @Override
    public void update() {
        System.out.println("实现了更新方法！");
    }

    @Override
    public void query() {
        System.out.println("实现了查询方法！");
    }
}
