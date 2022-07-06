package com.liyx.auth.utils;

import com.liyx.auth.translator.CommonResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ouyangxiap
 * @version 1.0
 * @date 2020/8/27 14:04
 */
public class MyAuthExceptionEntryPoint  implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        CommonResponse commonResponse = new CommonResponse();

        CommonUtil.makeResponse(
                response, MediaType.APPLICATION_JSON_UTF8_VALUE,
                HttpServletResponse.SC_UNAUTHORIZED, commonResponse.message("token无效")
        );
    }
}