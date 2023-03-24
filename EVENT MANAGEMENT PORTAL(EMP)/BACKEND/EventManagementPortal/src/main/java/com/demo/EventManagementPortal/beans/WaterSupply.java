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
@Table(name="watersupply")
public class WaterSupply {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int watersupplyid;
	private String name;
	@NotNull
	private int quantity;
	@NotNull
	private double rate;
	private String description;
	
	//relation between service and watersupply
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="serviceid")
	Services service=new Services();

	//constructor
	public WaterSupply() {
		super();	
	}

	public WaterSupply(String name, int quantity, double rate) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.rate = rate;
	}

	//getter and setter
	public int getWatersupplyid() {
		return watersupplyid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Services getService() {
		return service;
	}

	public void setService(Services service) {
		this.service = service;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	//tostring
	@Override
	public String toString() {
		return "WaterSupply [watersupplyid=" + watersupplyid + ", name=" + name + ", quantity=" + quantity + ", rate="
				+ rate + "]";
	}

}
