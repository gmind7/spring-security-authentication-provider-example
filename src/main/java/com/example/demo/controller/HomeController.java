package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        final SecurityContext securityContext = SecurityContextHolder.getContext();
        final Authentication authentication = securityContext.getAuthentication();
        System.out.println("HomeController Principal >>>>>>>>> : " + authentication.getPrincipal().toString());
        System.out.println("HomeController Authorities >>>>>>>>> : " + authentication.getAuthorities().toString());
        return "home";
    }
}
