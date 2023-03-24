package com.demo.EventManagementPortal.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.EventManagementPortal.beans.Payment;
import com.demo.EventManagementPortal.service.PaymentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/payment")
public class PaymentController {

	@Autowired(required=false)
	PaymentService paymentService;

	//add payment
	@PostMapping("/payments")
	public ResponseEntity<Payment> addpayment(@RequestBody Payment payment){
		paymentService.addpayment(payment);
		return new ResponseEntity<Payment>(payment,HttpStatus.CREATED);
	}	

	//getPayment by id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/payments/{paymentid}")
	public ResponseEntity<Payment> getpaymentById(@PathVariable int paymentid) {
		Payment payment=paymentService.getPaymentById(paymentid);
		if(payment!=null) {
			return new ResponseEntity(payment,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	//get all payments 
	@GetMapping("/payments")
	public ResponseEntity<List<Payment>> getAllPayments(){
		List<Payment> paymentlist=paymentService.getAllPayments();
		return ResponseEntity.ok(paymentlist);
	}

	//update payment
	@PutMapping("/payments")
	public ResponseEntity<String> updatePayment(@RequestBody Payment payment) {
		int n=paymentService.updatePayment(payment);
		if(n>0)
			return new ResponseEntity<String>("payment updated successfully "+payment,HttpStatus.CREATED);
		else
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	//delete payment
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/payments/{paymentid}")
	public ResponseEntity<String> deletePayment(@PathVariable int paymentid) {
		boolean status=paymentService.deletePayment(paymentid);
		if(status)
			return new ResponseEntity<String>("payment deleted successfully "+ paymentid,HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
