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
@Table(name="photography")
public class Photography {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int photographyid;
	private String name;
	private String type;
	@NotNull
	private double rate;
	private String description;
	
	//relation between service and photography
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="serviceid")
	Services service=new Services();
	
	//constructor
	public Photography() {
		super();	
	}

	public Photography(String name,String type, double rate) {
		super();
		this.name = name;
		this.type=type;
		this.rate = rate;
	}

	//getter and setter
	public int getPhotographyid() {
		return photographyid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public Services getService() {
		return service;
	}

	public void setService(Services service) {
		this.service = service;
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
		return "Photography [photographyid=" + photographyid + ", name=" + name + ", type=" + type + ", rate=" + rate
				+ "]";
	}

}
