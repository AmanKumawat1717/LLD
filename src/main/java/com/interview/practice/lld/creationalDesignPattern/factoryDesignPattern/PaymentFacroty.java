package com.interview.practice.lld.creationalDesignPattern.factoryDesignPattern;

public class PaymentFacroty {

    public static Payment createPayment(String type){
        if(type==null) throw  new IllegalArgumentException();
        switch (type.toLowerCase()){
            case "upi":
                return new UPIPayment();
            case "credit_card":
                return  new CreditCardPayment();
            default:
                throw new IllegalArgumentException();
        }
    }
}
