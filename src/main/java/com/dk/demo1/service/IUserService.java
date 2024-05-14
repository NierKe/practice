package com.dk.demo1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dk.demo1.pojo.User;

import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2023-10-10
 */
public interface IUserService extends IService<User> {

    public void add(User user);
    List<User> queryBatch(List<String> list);
    List<User> queryUsers(User user);
    public void delete();

    public boolean update(String id);

    public User query(String id);

    public List<User> queryLateUser();
}
