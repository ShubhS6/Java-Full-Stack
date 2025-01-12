package com.springboot_security.springBootSecurity.eventListener;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEvents {
    @EventListener
    public void successAuth(AuthenticationSuccessEvent ase){
        System.out.println("login Successfull for the user : "+ ase.getAuthentication().getName());
    }

    public void failureAuth(AbstractAuthenticationFailureEvent afe){
        System.out.println("login not successfull for the user : "+ afe.getAuthentication().getName());
        System.out.println("due to : "+afe.getException().getMessage());
    }
}
