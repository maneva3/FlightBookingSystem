package com.flightbookingsystem.web.view.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/login")
public class LoginViewController {
    @GetMapping
    public String getLogin(/*Model model, Authentication authentication*/) {
//        Authentication authentication2 = SecurityContextHolder.getContext().getAuthentication();
//        model.addAttribute("username", authentication.getName());
//
//        User principal = (User) authentication.getPrincipal();
//        model.addAttribute("username", principal.getAuthorities());
        return "login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "login";
    }

    @GetMapping("/unauthorized")
    public String unauthorized(){
        return "unauthorized";
    }
}
