package com.springboot_security.springBootSecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class securityConfiguration {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
       // http.authorizeHttpRequests(r->r.anyRequest().permitAll());
       // http.authorizeHttpRequests(r->r.anyRequest().denyAll());
       // http.authorizeHttpRequests(r->r.anyRequest().authenticated());
        http.authorizeHttpRequests(r->r.requestMatchers("/account","/balance","/loans","/cards").authenticated());
        http.authorizeHttpRequests(r->r.requestMatchers("/contact","/notices").permitAll());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }
}
