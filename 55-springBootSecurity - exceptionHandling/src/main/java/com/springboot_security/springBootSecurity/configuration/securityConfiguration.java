package com.springboot_security.springBootSecurity.configuration;

import com.springboot_security.springBootSecurity.exceptionHandling.customAccessDeniedHandler;
import com.springboot_security.springBootSecurity.exceptionHandling.customBasicAuthentication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Profile("!prod")
public class securityConfiguration {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(c->c.disable());
        http.authorizeHttpRequests(r->r.requestMatchers("/account","/balance","/loans","/cards").authenticated());
        http.authorizeHttpRequests(r->r.requestMatchers("/contact","/notices","/add").permitAll());
        http.formLogin(withDefaults());
        //when we want to handle the exception of bad credentials
        http.httpBasic(h->h.authenticationEntryPoint(new customBasicAuthentication()));
        //when we want to handle the exception globally or denied access to any page then we use it
        http.exceptionHandling(e->e.accessDeniedHandler(new customAccessDeniedHandler()));

        return http.build();
    }




    //during resistration and new password we can use compromisedPasswordChecker
    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
