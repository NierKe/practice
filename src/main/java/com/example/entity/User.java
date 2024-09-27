package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("USERTEST") // 对应数据库中的表名
public class User {
    @TableId
    private Long id;
    private String name;
    private Integer age;
}
