package com.demo.EventManagementPortal.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.EventManagementPortal.beans.Payment;
import com.demo.EventManagementPortal.dao.PaymentDao;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired(required=false)
	PaymentDao paymentDao;
	
	//add payment
	@Override
	public void addpayment(Payment payment) {
		paymentDao.saveAndFlush(payment);
	}

	//getPayment by id
	@Override
	public Payment getPaymentById(int paymentid) {
		Optional<Payment> op=paymentDao.findById(paymentid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	//get all payments
	@Override
	public List<Payment> getAllPayments() {
		return paymentDao.findAll();
	}

	//update payment
	@Override
	public int updatePayment(Payment payment) {
		Optional<Payment> op=paymentDao.findById(payment.getPaymentid());
		if(op.isPresent()) {
			Payment payment1=op.get();
			payment1.setPaidamount(payment.getPaidamount());
			payment1.setBalance(payment.getBalance());
			payment1.setTotalamount(payment.getTotalamount());
			payment1.setPaymentdate(payment.getPaymentdate());
			paymentDao.save(payment1);
			return 1;
		}
		return 0;
	}

	//delete payment
	@Override
	public boolean deletePayment(int paymentid) {
		Optional<Payment> op=paymentDao.findById(paymentid);
		if(op.isPresent()) {
			paymentDao.deleteById(paymentid);
			return true;
		}
		return false;
	}
}
