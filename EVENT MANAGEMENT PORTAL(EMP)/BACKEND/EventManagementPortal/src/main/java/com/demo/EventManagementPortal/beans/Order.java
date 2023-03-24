package com.demo.EventManagementPortal.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderid;
	@NotNull
	private String email;
	private String ordernumber;
	private String status;
	private int count=1;
	private String servicetype; 

	//relation between event and order
//	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
//	@JoinColumn(name="eventid")
//	private Event event=new Event();


	//relation between order and bill
//	@OneToOne(mappedBy ="order" ,fetch = FetchType.LAZY)
//	private Bill bill;

	public String getServicetype() {
		return servicetype;
	}

	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}

	//relation between order and datetime
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="datetimeid")
	private DateTime datetime=new DateTime();

	//constructor
	public Order() {
		super();
		this.ordernumber=generateOrderNumber();
	}

	public Order(String email,String status) {
		super();
		this.email = email;
		this.status=status;
		this.ordernumber=generateOrderNumber();
	}

	private String generateOrderNumber() {

		return "EMP00"+ count++;
	}

	//getter and setter
	public int getOrderid() {
		return orderid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrdernumber() {
		return ordernumber;
	}

	//tostring
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", email=" + email + ", ordernumber=" + ordernumber + ", status=" + status
				+ "]";
	}
}
