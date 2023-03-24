package com.demo.EventManagementPortal.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="decoration")
public class Decoration {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int decorationid;
	@NotNull
	private String categorytype;

	//relation between service and decoration
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="serviceid")
	private Services service=new Services();

//	//relation between decoration and flower
//	@OneToMany(mappedBy ="decoration")
//	List<Flower> flowerlist;

//	//relation between decoration and light
//	@OneToMany(mappedBy ="decoration")
//	List<Light> lightlist;

//	//relation between decoration and makeup
//	@OneToMany(mappedBy ="decoration")
//	List<Makeup> makeuplist;

	//constructor
	public Decoration() {
		super();
	}

	public Decoration(String categorytype) {
		super();
		this.categorytype = categorytype;
	}

	//getter and setter
	public int getDecorationid() {
		return decorationid;
	}

	public Services getService() {
		return service;
	}

	public void setService(Services service) {
		this.service = service;
	}

	public String getCategorytype() {
		return categorytype;
	}

	public void setCategorytype(String categorytype) {
		this.categorytype = categorytype;
	}

	//tostring
	@Override
	public String toString() {
		return "Decoration [decorationid=" + decorationid + ", categorytype=" + categorytype + "]";
	}

}
