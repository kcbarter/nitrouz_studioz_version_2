package com.N2O2.Nitrouz_Studioz.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        //todo put permitAll above athenticated
        http
            .authorizeRequests()
            .antMatchers().authenticated()
            .antMatchers( "/", "/css/main.css", "/js/about.js", "/js/homepage.js",
                "/js/signup.js", "/images/background.jpg", "/images/N2Oz_Nitrouz_Studioz.png",
                "/images/Nitrouz.png", "/images/Nitrouz_Studioz.png",
                "/images/secondary_background.jpg", "/images/Studioz.png", "/images/twitch.png",
                "/images/twitter.png", "/images/Youtube.png", "/about", "/signup",
                "/signUpFormError", "/Log_In", "/logOut", "/ForgotPasswordPage", "/Forgot_Password",
                "/SignUp", "/registrationComplete").permitAll()
            .and()
            .csrf().disable();
    }
}
