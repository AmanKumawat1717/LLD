package com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.refund;

public class RazorpayRefund implements Refund {

    @Override
    public void refund() {
        System.out.println("Razorpay refund");
    }
}