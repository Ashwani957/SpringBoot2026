package com.SecurityTwo.SecurityTwo.Controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String index(){
        return "index";
    }


    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/profile")
 // Role based acessing are used to provide the role and to enable the role based acessing we should enable the annotation
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String profile(){
        return "profile";
    }

    @GetMapping("/sign")
    public String signin(){
        return "login";
    }



}
