package com.springboot_security.springBootSecurity.configuration;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

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

    @Bean


    public UserDetailsService userDetailsService() {
       UserDetails userOne= User.withUsername("Ana").password("{noop}Vish@123").build();
       UserDetails userTwo=User.withUsername("Sumi").password("{bcrypt}$2a$12$WXDl0Sns22x2w8ifHr3ZnOfzelRt22pXH0uym6xs9TZZq5P2X5I2G").build();
        return new InMemoryUserDetailsManager(userOne,userTwo);
    }

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
