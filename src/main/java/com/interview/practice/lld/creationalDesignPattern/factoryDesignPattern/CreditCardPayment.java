package com.interview.practice.lld.creationalDesignPattern.factoryDesignPattern;

public class CreditCardPayment implements Payment{
    @Override
    public void pay() {
        System.out.println("Payment made via Credit Card.");
    }
}
