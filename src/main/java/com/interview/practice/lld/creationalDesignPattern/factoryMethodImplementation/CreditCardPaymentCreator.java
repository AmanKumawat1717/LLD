package com.interview.practice.lld.creationalDesignPattern.factoryMethodImplementation;

import com.interview.practice.lld.creationalDesignPattern.factoryDesignPattern.CreditCardPayment;
import com.interview.practice.lld.creationalDesignPattern.factoryDesignPattern.Payment;

public class CreditCardPaymentCreator extends PaymentCreator {

    @Override
    public Payment createPayment() {
        return new CreditCardPayment();
    }
}