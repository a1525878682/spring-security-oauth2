package com.liyx.auth.properties;

import lombok.Data;

/**
 * @author ouyangxiap
 * @version 1.0
 * @date 2020/8/27 13:48
 */
@Data
public class ClientsProperties {

    private String client;
    private String secret;
    private String grantType = "password,authorization_code,refresh_token";
    private String scope = "all";
}