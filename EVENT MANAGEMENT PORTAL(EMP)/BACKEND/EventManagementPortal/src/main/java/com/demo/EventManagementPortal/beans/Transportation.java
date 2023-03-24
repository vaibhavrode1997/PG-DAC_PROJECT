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
@Table(name="transportation")
public class Transportation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int transportationid;
	private String name;
	private String type;
	@NotNull
	private double rate;
	private String description;
	
	//relation between service and transportation
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="serviceid")
	Services service=new Services();

	//constructor
	public Transportation() {
		super();	
	}

	public Transportation(String name, String type, double rate) {
		super();
		this.name = name;
		this.type = type;
		this.rate = rate;
	}

	//getter and setter
	public int getTransportationid() {
		return transportationid;
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
		return "Transportation [transportationid=" + transportationid + ", name=" + name + ", type=" + type + ", rate="
				+ rate + "]";
	}

}
