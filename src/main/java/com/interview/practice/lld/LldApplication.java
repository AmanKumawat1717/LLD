package com.interview.practice.lld;

import com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.PaymentProviderFactory;
import com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.StripeFactory;
import com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.payment.StripePayment;
import com.interview.practice.lld.creationalDesignPattern.abstractFactroyDesignPattern.refund.Refund;
import com.interview.practice.lld.creationalDesignPattern.builderDesignPattern.Url;
import com.interview.practice.lld.creationalDesignPattern.factoryDesignPattern.Payment;
import com.interview.practice.lld.creationalDesignPattern.factoryDesignPattern.PaymentFacroty;
import com.interview.practice.lld.creationalDesignPattern.factoryMethodImplementation.PaymentCreator;
import com.interview.practice.lld.creationalDesignPattern.factoryMethodImplementation.UPIPaymentCreator;
import com.interview.practice.lld.creationalDesignPattern.prototypeDesignPattern.GameCharacter;
import com.interview.practice.lld.creationalDesignPattern.prototypeDesignPattern.Weapon;
import com.interview.practice.lld.creationalDesignPattern.singletonDesignPattern.doubleCheckLocking.DoubleCheckDBConnection;
import com.interview.practice.lld.creationalDesignPattern.singletonDesignPattern.lazyInitialization.DBConnection;
import com.interview.practice.lld.creationalDesignPattern.singletonDesignPattern.synchronizedInitialization.DBConnectionSync;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LldApplication {

	public static void main(String[] args) throws CloneNotSupportedException {
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

//		Prototype Design Pattern
		GameCharacter prototype = new GameCharacter("Solider",100,new Weapon("UZI","80"));
		System.out.println(System.identityHashCode(prototype));
		GameCharacter clone1 = prototype.clone();
		System.out.println(System.identityHashCode(clone1));
		// If we do not clone the inner Weapon object inside GameCharacter.clone(), both the original character and its clone will share the exact same Weapon instance (shallow copy).
		System.out.println("Prototype Weapon Hashcode: " + System.identityHashCode(prototype.getWeapon()));
		System.out.println("Clone Weapon Hashcode:     " + System.identityHashCode(clone1.getWeapon()));

//      Singleton Design Pattern
//		when we want to create only 1 instance of a class throughout the application.
//		Lazy Initialization -> issue we can end up creating multiple instances of DBConnection.
		Thread t1 = new Thread(() -> {
			DBConnection connection2 = DBConnection.getInstance();
			System.out.println(Thread.currentThread().getName() + " -> " + System.identityHashCode(connection2));
		}, "Thread-1");

		Thread t2 = new Thread(() -> {
			DBConnection connection3 = DBConnection.getInstance();
			System.out.println(Thread.currentThread().getName() + " -> "+ System.identityHashCode(connection3));

		}, "Thread-2");
		t1.start();
		t2.start();
		//		Sync Initialization -> issue [Suppose there are 1000's of
		//request comes in parllel , so
		//each time you have to put lock
		//and unlock and locking is
		// very expensive operation.]
		Thread t3 = new Thread(() -> {
			DBConnectionSync connection4 = DBConnectionSync.getInstance();
			System.out.println(Thread.currentThread().getName() + " -> " + System.identityHashCode(connection4));
		}, "Thread-3");

		Thread t4 = new Thread(() -> {
			DBConnectionSync connection5 = DBConnectionSync.getInstance();
			System.out.println(Thread.currentThread().getName() + " -> "+ System.identityHashCode(connection5));

		}, "Thread-4");
		t3.start();
		t4.start();

		//	Double Check Locking
		Thread t5 = new Thread(() -> {
			DoubleCheckDBConnection connection5 = DoubleCheckDBConnection.getInstance();
			System.out.println(Thread.currentThread().getName() + " -> " + System.identityHashCode(connection5));
		}, "Thread-5");

		Thread t6 = new Thread(() -> {
			DoubleCheckDBConnection connection6 = DoubleCheckDBConnection.getInstance();
			System.out.println(Thread.currentThread().getName() + " -> "+ System.identityHashCode(connection6));

		}, "Thread-6");
		t5.start();
		t6.start();

//		 Builder Design Pattern
//		When we wants to create different representations of and class via using same constructor.

		Url.UrlBuilder builder = new Url.UrlBuilder();
		Url url = builder.setProtocol("https://")
				.setHost("www.practicelld.com")
				.setBasePath("/creationaldesignpattern/")
				.setPathParam("/12345")
				.setQueryParam("?pattern=builder")
				.setBody("{\"name\":\"Aman\"}")
				.build();

		System.out.println(url);
	}


}
