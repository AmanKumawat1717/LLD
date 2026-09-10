package com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.refund;

public class StripeRefund implements Refund {

    @Override
    public void refund() {
        System.out.println("Stripe refund");
    }
}