package com.snipper.springDemoApplication.Service;

public class Paytm implements paymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Paythm");
    }
}
