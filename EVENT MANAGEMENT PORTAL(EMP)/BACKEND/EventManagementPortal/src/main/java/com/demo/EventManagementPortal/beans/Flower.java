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
@Table(name="flower")
public class Flower {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int flowerid;
	private String name;
	@NotNull
	private String type;
	private double rate;
	private String description;
	
	//relation between decoration and flower
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="decorationid")
	Decoration decoration=new Decoration();

	//constructor
	public Flower() {
		super();	
	}

	public Flower(String name, String type, double rate) {
		super();
		this.name = name;
		this.type = type;
		this.rate = rate;
	}

	//getter and setter
	public int getFlowerid() {
		return flowerid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Decoration getDecoration() {
		return decoration;
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
		return "Flower [flowerid=" + flowerid + ", name=" + name + ", type=" + type + ", rate=" + rate + "]";
	}


}
