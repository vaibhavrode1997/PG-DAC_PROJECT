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
@Table(name="musicsystem")
public class Musicsystem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int musicsystemid;
	private String musicsystemname;
	@NotNull
	private double rate;
	private String description;
	
	//relation between service and musicsystem
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="serviceid")
	Services service=new Services();

	//constructor
	public Musicsystem() {
		super();	
	}

	public Musicsystem(String musicsystemname, double rate) {
		super();
		this.musicsystemname = musicsystemname;
		this.rate = rate;
	}

	//getter and setter
	public int getMusicsystemid() {
		return musicsystemid;
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

	public String getMusicsystemname() {
		return musicsystemname;
	}

	public void setMusicsystemname(String musicsystemname) {
		this.musicsystemname = musicsystemname;
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
		return "Musicsystem [musicsystemid=" + musicsystemid + ", musicsystemname=" + musicsystemname + ", rate=" + rate
				+ "]";
	}

}
