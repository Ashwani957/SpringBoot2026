package com.snipper.springDemoApplication.Entity;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class ScopeBean {

    public ScopeBean(){
            System.out.println("ScopeBean");
    }

    @PostConstruct
    public void init(){
        System.out.println("Scope Bean "+this.hashCode());
    }


}
