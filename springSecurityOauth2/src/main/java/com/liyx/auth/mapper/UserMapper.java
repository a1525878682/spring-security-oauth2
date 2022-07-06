package com.liyx.auth.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liyx.auth.entity.User;

/**
 * @author ouyangxiap
 * @version 1.0
 * @date 2020/8/28 16:19
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 通过用户名查找用户信息
     * @param username
     * @return
     */
    User findByName(String username);


}
