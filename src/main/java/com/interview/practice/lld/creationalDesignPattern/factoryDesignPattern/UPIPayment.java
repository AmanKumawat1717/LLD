package com.interview.practice.lld.creationalDesignPattern.factoryDesignPattern;

public class UPIPayment implements Payment{
    @Override
    public void pay() {
        System.out.println("Payment made via UPI.");
    }
}
