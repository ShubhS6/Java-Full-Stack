package com.spring_crud_jpa.spring_crud_jpa.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class securityConfiguration {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails shubham= User.builder()
                .username("shubham")
                .password("{noop}shubham@123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails sumit= User.builder()
                .username("sumit")
                .password("{noop}sumit@123")
                .roles("EMPLOYEE")
                .build();

        UserDetails anil= User.builder()
                .username("anil")
                .password("{noop}anil@123")
                .roles("MANAGER")
                .build();
        return new  InMemoryUserDetailsManager(shubham,sumit,anil);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configure->
                configure.requestMatchers(HttpMethod.GET,"/employee/all").hasAnyRole("EMPLOYEE","MANAGER")
                        .requestMatchers(HttpMethod.GET,"/employee/searchName/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST,"/employee/save").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/employee/update").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.DELETE
                                ,"/employee/delete").hasRole("MANAGER")
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csfr->csfr.disable());
        return http.build();
    }
}
