package com.snipper.springDemoApplication.config;


import com.snipper.springDemoApplication.Service.CreaditCard;
import com.snipper.springDemoApplication.Service.DebitCard;
import com.snipper.springDemoApplication.Service.Gpay;
import com.snipper.springDemoApplication.Service.paymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

//    @Bean
    public paymentService  creditService(){
        return  new CreaditCard();
    }

//    @Bean
    public paymentService debitCardService(){
        return new DebitCard();
    }

//    @Bean
    public paymentService Gpay(){
        return new Gpay();
    }



}
