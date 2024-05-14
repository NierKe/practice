package com.dk.demo1.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2023-10-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
public class User implements Serializable,Cloneable{

    private static final long serialVersionUID = 1L;

    /**
     * 用户id,手机号码
     */
    private Long id;

    private String nickname;

    /**
     * MD5(MD5(pass明文+固定salt)+salt)
     */
    private String password;

    private String salt;

    /**
     * 头像
     */
    private String head;

    /**
     * 注册时间
     */
    private LocalDateTime registerDate;

    /**
     * 最后一次登陆时间
     */
    private LocalDateTime lastLoginDate;

    /**
     * 登录次数
     */
    private Integer loginCount;

    public User() {
    }

    public User(Long id, String nickname, String password, String salt, String head, LocalDateTime registerDate, LocalDateTime lastLoginDate, Integer loginCount) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.salt = salt;
        this.head = head;
        this.registerDate = registerDate;
        this.lastLoginDate = lastLoginDate;
        this.loginCount = loginCount;
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        return (User)super.clone();
    }
}
