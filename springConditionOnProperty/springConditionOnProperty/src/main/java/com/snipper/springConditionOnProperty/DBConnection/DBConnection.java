package com.snipper.springConditionOnProperty.DBConnection;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBConnection {

//    if the bean is not created then mark this fields as null and move ahead so we did not get any error
    @Autowired(required = false)
    MySQL mysql ;
    @Autowired(required = false)
    NOSQL nosql ;


//    @PostConstruct
    @PostConstruct
    public void  inti(){
        System.out.println("DBConnection init");
        System.out.println("MY SQL Connection"+mysql);
        System.out.println("NoSqlConneection"+nosql);

    }
}
