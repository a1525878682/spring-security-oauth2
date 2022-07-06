package com.liyx.auth.service;


import com.liyx.auth.entity.AuthUser;
import com.liyx.auth.entity.User;
import com.liyx.auth.entity.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserManager userManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User systemUser = userManager.findByName(username);
        if (systemUser != null) {
            String permissions = userManager.findUserPermissions(systemUser.getUserName());
            AuthUser authUser = new AuthUser(systemUser.getUserName(), systemUser.getPwd(), true, true, true, true,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(permissions));

            return transSystemUserToAuthUser(authUser, systemUser);
        } else {
            throw new UsernameNotFoundException("");
        }
    }

    private AuthUser transSystemUserToAuthUser(AuthUser authUser, User systemUser) {
        authUser.setDeptId(systemUser.getDeptId());
        authUser.setRealName(systemUser.getRealName());
        authUser.setGroupId(systemUser.getPermGroup());
        authUser.setDeptName(systemUser.getDeptName());
        authUser.setMobile(systemUser.getMobile());
        authUser.setRoleId(systemUser.getRoleId());
        authUser.setRoleName(systemUser.getRoleName());
        authUser.setUserId(systemUser.getUserId());
        authUser.setLoginFlag(systemUser.getLoginFlag());
        authUser.setUserType(systemUser.getUserType());
        return authUser;
    }
}