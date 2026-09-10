package com.interview.practice.lld;

import com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.PaymentProviderFactory;
import com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.StripeFactory;
import com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.payment.StripePayment;
import com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.refund.Refund;
import com.interview.practice.lld.creationalDesignPattern.factoryDesignPattern.Payment;
import com.interview.practice.lld.creationalDesignPattern.factoryDesignPattern.PaymentFacroty;
import com.interview.practice.lld.creationalDesignPattern.factoryMethodImplementation.PaymentCreator;
import com.interview.practice.lld.creationalDesignPattern.factoryMethodImplementation.UPIPaymentCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LldApplication {

	public static void main(String[] args) {
		SpringApplication.run(LldApplication.class, args);


//		Factory Design Pattern
//		Factory Pattern encapsulates object-creation logic and hides
//		the concrete implementation classes from the client.
		Payment onlinePayment = PaymentFacroty.createPayment("UPI");
		onlinePayment.pay();

//		Factory Method [follows OCP]
//		[Parent abstract class tells us what sort of
//		functionality to implement in our case payment but children
//		decides what type of object i want to create to implement that functionality.]
		PaymentCreator upiCreator = new UPIPaymentCreator();
		Payment upi = upiCreator.createPayment();
		upi.pay();

//		Abstract Factory Design Pattern
		PaymentProviderFactory factory = new StripeFactory();
		com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.payment.Payment payment = factory.createPayment();
		payment.pay();
		Refund refund = factory.createRefund();
		refund.refund();
	}

}
