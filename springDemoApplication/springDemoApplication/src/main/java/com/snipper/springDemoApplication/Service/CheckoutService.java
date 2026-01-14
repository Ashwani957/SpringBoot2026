package com.snipper.springDemoApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

    @Autowired
paymentService paymentService;

    public void checkoutOrder(double amount){
        paymentService.processPayment(amount);
        System.out.println("Checkout order for amount"+amount);
    }
}
