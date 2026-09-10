package com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.payment;

public class RazorpayPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Razorpay payment");
    }
}