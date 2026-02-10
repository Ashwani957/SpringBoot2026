package com.snipper.springConditionOnProperty.DBConnection;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
//@ConditionalOnProperty(
//        prefix="sqlcon",
//        value = "enabled",
//        havingValue = "true",
//        matchIfMissing=false
//)
//profile annotaion help me to tell when we need to create the object of it dev
@Profile("dev")
public class MySQL {

    @Value("${username}")
    String username;
    @Value("${password}")
    String password;
    @Value("${portUrl}")
    String portUrl;
    public MySQL(){
        System.out.println("MYSQL Connection established");
    }
}
