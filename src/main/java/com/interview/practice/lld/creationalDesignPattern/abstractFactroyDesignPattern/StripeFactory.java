package com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern;

import com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.payment.Payment;
import com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.payment.StripePayment;
import com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.refund.Refund;
import com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.refund.StripeRefund;

public class StripeFactory implements PaymentProviderFactory {

    @Override
    public Payment createPayment() {
        return new StripePayment();
    }

    @Override
    public Refund createRefund() {
        return new StripeRefund();
    }
}