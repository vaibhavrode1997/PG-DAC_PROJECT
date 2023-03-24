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
@Table(name="hall")
public class Hall {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int hallid;
	private String name;
	@NotNull
	private int capacity;
	@NotNull
	private double rate;
	private String description;

	//relation between service and hall
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="serviceid")
	private Services service=new Services();

	//constructor
	public Hall() {
		super();
	}

	public Hall(String name, int capacity, double rate, String description) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.rate = rate;
		this.description = description;
	
	}

	//getter and setter
	public int getHallid() {
		return hallid;
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//tostring
	@Override
	public String toString() {
		return "Hall [hallid=" + hallid + ", name=" + name + ", capacity=" + capacity + ", rate=" + rate + ", description=" + description + "]";
	}

}
