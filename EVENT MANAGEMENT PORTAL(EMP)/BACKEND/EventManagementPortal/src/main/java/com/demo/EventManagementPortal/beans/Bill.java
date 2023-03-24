package com.demo.EventManagementPortal.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="bill")
public class Bill {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int billid;
	private int amount;
	private int tax;
	private int totalamount;
	
	private String servicetype;
	
	@Temporal(TemporalType.DATE)
	private Date date = new java.sql.Date(new java.util.Date().getTime());
	
	@OneToOne
	@JoinColumn(name="userid")
	private User user=new User();
//	
//	//relation between bill and order
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "orderid")
//	private Order order=new Order();
//	
	//constructor
	public Bill() {
		super();
		
	}
	public Bill(int amount, int tax, int totalamount, Date date) {
		super();
		this.amount = amount;
		this.tax = tax;
		this.totalamount = totalamount;
		this.date = date;
	}
	
	//getter and settre
	public String getServicetype() {
		return servicetype;
	}
	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}

	public int getBillid() {
		return billid;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	
	public int getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	//tostring
	@Override
	public String toString() {
		return "Bill [billid=" + billid + ", amount=" + amount + ", tax=" + tax
				+ ", totalamount=" + totalamount + ", date=" + date + "]";
	}
	
}
