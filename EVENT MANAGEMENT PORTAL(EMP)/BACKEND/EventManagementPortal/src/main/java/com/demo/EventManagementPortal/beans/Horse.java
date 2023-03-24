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
@Table(name="horse")
public class Horse {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int horseid;
	private String name;
	private String color;
	@NotNull
	private double rate;
	private String description;
	
	//relation between service and horse
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="serviceid")
	Services service=new Services();

	//constructor
	public Horse() {
		super();	
	}

	public Horse(String name, String color, double rate) {
		super();
		this.name = name;
		this.color = color;
		this.rate = rate;
	}

	//getter and setter
	public int getHorseid() {
		return horseid;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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
		return "Horse [horseid=" + horseid + ", name=" + name + ", color=" + color + ", rate=" + rate + "]";
	}

}
