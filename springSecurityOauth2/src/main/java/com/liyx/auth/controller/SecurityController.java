package com.liyx.auth.controller;


import com.liyx.auth.entity.AuthUser;
import com.liyx.auth.service.ValidateCodeService;
import com.liyx.auth.translator.CommonResponse;
import com.liyx.auth.translator.ValidateCodeException;
import com.liyx.auth.utils.CommonUtil;
import com.liyx.auth.utils.ResultObj;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;

/**
 * @author ouyangxiap
 * @version 1.0
 * @date 2020/8/26 16:07
 */
@RestController
public class SecurityController {

    @Autowired
    HttpServletRequest request;

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @Autowired
    private ValidateCodeService validateCodeService;

    @GetMapping("oauth/test")
    public String testOauth() {
        return "oauth";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }


    @DeleteMapping("signout")
    public CommonResponse signout(HttpServletRequest request) throws AuthException {
        String authorization = request.getHeader("Authorization");
        String token = StringUtils.replace(authorization, "bearer ","");
        CommonResponse commonResponse = new CommonResponse();
        if (!consumerTokenServices.revokeToken(token)) {
            throw new AuthException("退出登录失败");
        }
        return commonResponse.message("退出登录成功");
    }

    @GetMapping("captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException, ValidateCodeException {
        validateCodeService.create(request, response);
    }

    @GetMapping("checkCaptcha")
    public ResultObj checkCaptcha(String key, String value) {
        try {
            validateCodeService.check(key, value);
            return ResultObj.ASSETS_DEFINE_SUCCESS;
        } catch (ValidateCodeException e) {
            e.printStackTrace();
            return ResultObj.ASSETS_DEFINE_ERROR;
        }

    }


}