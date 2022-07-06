package com.liyx.auth;

import com.liyx.auth.utils.MyAccessDeniedHandler;
import com.liyx.auth.utils.MyAuthExceptionEntryPoint;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author apple
 */
@SpringBootApplication
@MapperScan("com.liyx.auth.mapper")
public class SpringSecurityOauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityOauth2Application.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public MyAccessDeniedHandler myAccessDeniedHandler() {
        return new MyAccessDeniedHandler();
    }

    @Bean
    public MyAuthExceptionEntryPoint myAuthExceptionEntryPoint() {
        return new MyAuthExceptionEntryPoint();
    }

}
