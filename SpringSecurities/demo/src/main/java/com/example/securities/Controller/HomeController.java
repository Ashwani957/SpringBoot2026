package com.example.securities.Controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


    @RequestMapping("/index")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String getIndex(){
        return "index";
    }

    @RequestMapping("/home")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")  // this page is only access by the admin
    public String getHome(){
        return "home";
    }

    @RequestMapping("/about")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String getAbout(){
        return "about";
    }

}
