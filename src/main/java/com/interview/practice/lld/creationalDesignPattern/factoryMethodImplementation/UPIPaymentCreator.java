package com.interview.practice.lld.creationalDesignPattern.factoryMethodImplementation;

import com.interview.practice.lld.creationalDesignPattern.factoryDesignPattern.Payment;
import com.interview.practice.lld.creationalDesignPattern.factoryDesignPattern.UPIPayment;

public class UPIPaymentCreator extends PaymentCreator{
    @Override
    public Payment createPayment() {
        return new UPIPayment();
    }
}
