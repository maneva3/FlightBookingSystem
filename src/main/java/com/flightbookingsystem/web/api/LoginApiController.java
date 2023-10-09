package com.flightbookingsystem.web.api;

import com.flightbookingsystem.data.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/login")
public class LoginApiController {
    @RequestMapping
    public String getLogin() {
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
