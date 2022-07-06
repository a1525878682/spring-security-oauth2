package com.liyx.auth.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author ouyangxiap
 * @version 1.0
 * @date 2020/8/27 13:49
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:auth.properties"})
@ConfigurationProperties(prefix = "auth")
public class AuthProperties {

    private ClientsProperties[] clients = {};
    private int accessTokenValiditySeconds = 60 * 60 * 24;
    private int refreshTokenValiditySeconds = 60 * 60 * 24 * 7;

    /**
     *   免认证路径
     */
    private String anonUrl;

    /**
     *  验证码配置类
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();
}
