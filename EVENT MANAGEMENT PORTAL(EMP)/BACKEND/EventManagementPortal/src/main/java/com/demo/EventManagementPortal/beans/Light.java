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
@Table(name="light")
public class Light {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int lightid;
	private String name;
	private String type;
	@NotNull
	private double rate;
	private String description;
	
	//relation between decoration and light
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="decorationid")
	private Decoration decoration=new Decoration();

	//constructor
	public Light() {
		super();	
	}

	public Light(String name, String type, double rate) {
		super();
		this.name = name;
		this.type = type;
		this.rate = rate;
	}

	//getter and setter
	public int getLightid() {
		return lightid;
	}

	public Decoration getDecoration() {
		return decoration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDecoration(Decoration decoration) {
		this.decoration = decoration;
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
		return "Flower [lightid=" + lightid + ", name=" + name + ", type=" + type + ", rate=" + rate + "]";
	}

}
