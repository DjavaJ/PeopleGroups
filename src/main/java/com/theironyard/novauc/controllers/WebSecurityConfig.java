package com.theironyard.novauc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dangelojoyce on 3/31/17.
 */
    @RestController
    @Configuration
    @EnableWebSecurity
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        //@Override
        protected void configure(HttpSecurity http, AuthenticationManagerBuilder auth) throws Exception {



            http
                    .authorizeRequests()
                    .antMatchers("/", "/user").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                    .logout()
                    .permitAll();
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication().withUser("bob").password("pass").roles("USER");
            auth.inMemoryAuthentication().withUser("sally").password("pass").roles("USER");
        }
    }



