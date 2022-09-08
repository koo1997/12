package com.javateam.SpringBootNaverOAuth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.javateam.SpringBootNaverOAuth.domain.Role;
import com.javateam.SpringBootNaverOAuth.service.CustomOAuth2UserService;


@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    
    	http
            .csrf().disable()
            .headers().frameOptions().disable()
            .and()
                .authorizeRequests() // profile ???
                .antMatchers("/", "/css/**", "/webjars/**", "/images/**", "/js/**", "/profile").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                // .antMatchers("/login/oauth2/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
            .and()
                .logout()
                    .logoutSuccessUrl("/")
            .and()
                .oauth2Login()
                    .userInfoEndpoint()
                        .userService(customOAuth2UserService);
    }
    
}