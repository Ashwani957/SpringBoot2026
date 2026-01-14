package com.snipper.springDemoApplication.Service;

public class CreaditCard implements paymentService{
    @Override
    public void processPayment(double amount) {
        System.out.println("CreditCard Service");
    }
}
