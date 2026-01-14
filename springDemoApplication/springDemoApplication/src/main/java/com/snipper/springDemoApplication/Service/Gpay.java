package com.snipper.springDemoApplication.Service;

import org.springframework.stereotype.Service;

@Service
public class Gpay implements  paymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Gpay Payment Processing ");
    }
}
