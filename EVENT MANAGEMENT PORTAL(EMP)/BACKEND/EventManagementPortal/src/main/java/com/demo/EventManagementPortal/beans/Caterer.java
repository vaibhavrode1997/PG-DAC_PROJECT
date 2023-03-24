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
@Table(name="caterer")
public class Caterer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int catererid;
	@NotNull
	private String name;
	private String description;
	private String capacity;
	@NotNull
	private String item;
	@NotNull
	private double rate;

	//relation between service and caterer
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="serviceid")
	Services service=new Services();

	//constructor
	public Caterer() {
		super();
	}

	public Caterer(String name, String description, String capacity, String item, double rate) {
		super();
		this.name = name;
		this.description = description;
		this.capacity = capacity;
		this.item = item;
		this.rate = rate;
	}

	//getter and setter
	public int getCatererid() {
		return catererid;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
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
		return "Caterer [catererid=" + catererid + ", name=" + name + ", description=" + description + ", capacity="
				+ capacity + ", item=" + item + ", rate=" + rate + "]";
	}	

}
