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

@Entity
@Table(name="firecrackers")
public class FireCrackers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int firecrackersid;
	private String name;
	private String type;
	private double rate;
	private String description;
	
	//relation between service and firecrackers
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="serviceid")
	Services service=new Services();

	//constructor
	public FireCrackers() {
		super();	
	}

	public FireCrackers(String name, String type, double rate) {
		super();
		this.name = name;
		this.type = type;
		this.rate = rate;
	}

	//getter and setter
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFirecrackersid() {
		return firecrackersid;
	}

	public Services getService() {
		return service;
	}

	public void setService(Services service) {
		this.service = service;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		return "FireCrackers [firecrackersid=" + firecrackersid + ", name=" + name + ", type=" + type + ", rate=" + rate
				+ "]";
	}

}
