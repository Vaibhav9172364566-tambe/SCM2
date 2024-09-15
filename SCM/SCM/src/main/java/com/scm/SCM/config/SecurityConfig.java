package com.scm.SCM.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    //user create and login using java code with in memory services

    // @Bean
    // public UserDetailsService userDetailsService(){

    //     UserDetails user1=  User
    //     .withDefaultPasswordEncoder()
    //     .username("vaibhav")
    //     .password("vaibhav")
    //     .roles("ADMIN","USER")
    //     .build();

       
    //     UserDetails user2= User.withUsername("tambe")
    //     .password("tambe")
    //    // .roles("ADMIN","USER")
    //     .build();

    //     var inMemoryUserDetailsManager=new InMemoryUserDetailsManager(user1,user2);
    //     return inMemoryUserDetailsManager;
    // }


}
