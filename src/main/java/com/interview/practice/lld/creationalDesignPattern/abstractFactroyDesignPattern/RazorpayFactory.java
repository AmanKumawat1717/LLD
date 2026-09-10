package com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern;

import com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.payment.Payment;
import com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.payment.RazorpayPayment;
import com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.refund.RazorpayRefund;
import com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.refund.Refund;

class RazorpayFactory implements PaymentProviderFactory {

    @Override
    public Payment createPayment() {
        return new RazorpayPayment();
    }

    @Override
    public Refund createRefund() {
        return new RazorpayRefund();
    }
}