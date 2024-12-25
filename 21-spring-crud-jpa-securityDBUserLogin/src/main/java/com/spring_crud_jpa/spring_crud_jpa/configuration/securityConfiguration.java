package com.spring_crud_jpa.spring_crud_jpa.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class securityConfiguration {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configure->
                configure.requestMatchers(HttpMethod.GET,"/employee/all").hasAnyRole("EMPLOYEE","MANAGER")
                        .requestMatchers(HttpMethod.GET,"/employee/searchName/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST,"/employee/save").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/employee/update").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.DELETE,"/employee/delete").hasRole("MANAGER")
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csfr->csfr.disable());
        return http.build();
    }
}
