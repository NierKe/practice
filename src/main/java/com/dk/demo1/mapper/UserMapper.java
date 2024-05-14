package com.dk.demo1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dk.demo1.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2023-10-10
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    public void add(User user);

    //foreach标签
    List<User> queryBatch(List<String> list);

    List<User> queryUsers(User user);

    public void delete();

    public boolean update(String id);

    public User query(String id);

    public List<User> queryLateUser();
}
