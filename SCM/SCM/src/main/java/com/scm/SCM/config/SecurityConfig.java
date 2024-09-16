package com.scm.SCM.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.scm.SCM.services.impl.SecurityCustomUserDetailsService;

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

    @Autowired
    private SecurityCustomUserDetailsService userDetailsService;

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();

        //user service ka object

        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        //password encoder ka object
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;

    }

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();

    }


}
