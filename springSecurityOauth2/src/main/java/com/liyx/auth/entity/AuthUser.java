package com.liyx.auth.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Date;

/**
 * @author ouyangxiap
 * @version 1.0
 * @date 2020/8/26 16:02
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AuthUser extends User {
    private static final long serialVersionUID = -6411066541689297219L;

    private Integer userId;

    private String avatar;

    private String email;

    private String mobile;

    private String sex;

    private Integer deptId;

    private String deptName;

    private String roleId;

    private String roleName;

    private Date lastLoginTime;

    private String description;

    private String status;

    public void setRealName(String realName) {
        this.realName = realName;
    }

    private String realName;

    private Integer groupId;

    private String loginFlag;

    private String userType;

    /**
     * 支撑单位ID
     */
    private Integer supportId;

    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
    }

    public AuthUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public AuthUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}