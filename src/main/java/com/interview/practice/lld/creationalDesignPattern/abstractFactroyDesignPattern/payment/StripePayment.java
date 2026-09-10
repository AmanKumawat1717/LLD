package com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.payment;

public class StripePayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Stripe payment");
    }
}