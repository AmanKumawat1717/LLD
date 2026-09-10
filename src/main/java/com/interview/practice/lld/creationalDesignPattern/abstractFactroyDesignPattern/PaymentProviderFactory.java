package com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern;

import com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.payment.Payment;
import com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.refund.Refund;

public interface PaymentProviderFactory {

    Payment createPayment();
    Refund createRefund();
}
