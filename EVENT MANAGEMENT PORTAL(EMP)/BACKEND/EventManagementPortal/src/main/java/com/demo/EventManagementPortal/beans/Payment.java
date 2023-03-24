package com.demo.EventManagementPortal.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="payment")
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int paymentid;
	private double paidamount;
	private double balance;
	private double totalamount;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date paymentdate;
	
	//relation between payment and bill
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="billid")
	private Bill bill=new Bill();
	
	//constructor
	public Payment() {
		super();
	}

	public Payment(double paidamount, double balance, double totalamount, Date paymentdate) {
		super();
		this.paidamount = paidamount;
		this.balance = balance;
		this.totalamount = totalamount;
		this.paymentdate = paymentdate;
	}

	//getter and setter
	public int getPaymentid() {
		return paymentid;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	
	public double getPaidamount() {
		return paidamount;
	}

	public void setPaidamount(double paidamount) {
		this.paidamount = paidamount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}

	public Date getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(Date paymentdate) {
		this.paymentdate = paymentdate;
	}

	//tostring
	@Override
	public String toString() {
		return "Payment [paymentid=" + paymentid + ", paidamount=" + paidamount + ", balance="
				+ balance + ", totalamount=" + totalamount + ", paymentdate=" + paymentdate + "]";
	}
	
}
