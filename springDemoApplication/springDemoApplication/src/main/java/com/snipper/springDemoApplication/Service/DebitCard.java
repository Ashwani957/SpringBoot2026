package com.snipper.springDemoApplication.Service;

public class DebitCard implements paymentService{
    @Override
    public void processPayment(double amount) {
        System.out.println("Debit Card is Processing");
    }
}
