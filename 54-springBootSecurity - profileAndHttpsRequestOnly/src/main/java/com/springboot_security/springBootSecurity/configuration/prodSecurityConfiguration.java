package com.springboot_security.springBootSecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;
import org.springframework.stereotype.Component;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Profile("prod")
public class prodSecurityConfiguration {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        //http.authorizeHttpRequests(r->r.anyRequest().permitAll());
        // http.authorizeHttpRequests(r->r.anyRequest().denyAll());
        // http.authorizeHttpRequests(r->r.anyRequest().authenticated());
        //only https connection
        http.requiresChannel(rc->rc.anyRequest().requiresSecure())
        .csrf(c->c.disable());
        http.authorizeHttpRequests(r->r.requestMatchers("/account","/balance","/loans","/cards").authenticated());
        http.authorizeHttpRequests(r->r.requestMatchers("/contact","/notices","/add").denyAll());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }


    /*

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

     */


    //during resistration and new password we can use compromisedPasswordChecker
    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // return new BCryptPasswordEncoder();
        //or
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
