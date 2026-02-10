package com.snipper.springConditionOnProperty.ascept;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Loginascept {


//    we can use different different anntoatin Here
//    we can also use the * so that it can track all the service  or method
//    instead of Before we can also use like this : Before , after , @Around are used when we want to use both after and before

    @Before("execution(* com.snipper.springConditionOnProperty.Controller.Product.getProductByid(..))")
    public void log() {
        System.out.println("Aspect log called");
    }
}
