package com.N2O2.Nitrouz_Studioz;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.test.context.ContextConfiguration;

@Order(1)
@ContextConfiguration(classes = NitrouzStudiozApplication.class)
public class TestSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers( "/**")
            .permitAll()
            .anyRequest().authenticated();
    }
}
