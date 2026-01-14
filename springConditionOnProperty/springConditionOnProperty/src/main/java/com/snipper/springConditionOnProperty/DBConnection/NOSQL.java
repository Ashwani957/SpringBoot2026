package com.snipper.springConditionOnProperty.DBConnection;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(
        prefix="nosqlconnection",
        value="enabled",
        havingValue = "true",
        matchIfMissing = false
)
//important points : matchIfMissing : Means if the application.prorpeties me configuration missing h tab use krenge agar value true h  toa nahi toa nahi krega
public class NOSQL {

    public NOSQL(){
        System.out.println("NOSQL Connection established");
    }

}
