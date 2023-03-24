package com.demo.EventManagementPortal.service;
import java.util.List;
import com.demo.EventManagementPortal.beans.Payment;

public interface PaymentService {
	//add payment
	void addpayment(Payment payment);

	//getPayment by id
	Payment getPaymentById(int paymentid);

	//get all payments 
	List<Payment> getAllPayments();

	//update payment
	int updatePayment(Payment payment);

	//delete payment
	boolean deletePayment(int paymentid);
}
