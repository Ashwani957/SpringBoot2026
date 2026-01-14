package com.snipper.springConditionOnProperty.DBConnection;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@ConditionalOnProperty(
        prefix="sqlcon",
        value = "enabled",
        havingValue = "true",
        matchIfMissing=false
)
public class MySQL {

    public MySQL(){
        System.out.println("MYSQL Connection established");
    }
}
