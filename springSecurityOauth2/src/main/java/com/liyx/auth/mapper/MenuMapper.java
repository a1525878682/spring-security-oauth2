package com.liyx.auth.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liyx.auth.entity.Menu;

import java.util.List;

/**
 * @author ouyangxiap
 * @version 1.0
 * @date 2020/8/28 16:19
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 通过用户名查找用户权限集合
     * @param username
     * @return
     */
    List<Menu> findUserPermissions(String username);
}
