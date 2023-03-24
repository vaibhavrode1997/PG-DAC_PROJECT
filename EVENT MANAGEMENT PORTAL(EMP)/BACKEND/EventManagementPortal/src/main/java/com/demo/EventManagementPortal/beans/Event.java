package com.demo.EventManagementPortal.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="event")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eventid;
	@NotNull
	private String eventtype;

	//relation between event and service
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinTable(name = "eventservicelist", joinColumns = @JoinColumn(name = "eventid"), inverseJoinColumns = @JoinColumn(name = "serviceid"))
	private List<Services> servicelist;

	//relation between event and order 
//	@OneToMany(mappedBy = "event")
//	List<Order> orderlist;

	//constructor
	public Event() {
		super();
	}

	public Event(int eventid, String eventtype) {
		super();
		this.eventid = eventid;
		this.eventtype = eventtype;
	}

	//getter and setter
	public int getEventid() {
		return eventid;
	}

//	public List<Order> getOrderlist() {
//		return orderlist;
//	}
//
//	public void setOrderlist(List<Order> orderlist) {
//		this.orderlist = orderlist;
//	}

	public List<Services> getServicelist() {
		return servicelist;
	}

	public void setServicelist(List<Services> servicelist) {
		this.servicelist = servicelist;
	}

	public void setEventid(int eventid) {
		this.eventid = eventid;
	}

	public String getEventtype() {
		return eventtype;
	}

	public void setEventtype(String eventtype) {
		this.eventtype = eventtype;
	}

	//toString
	@Override
	public String toString() {
		return "Event [eventid=" + eventid + ", eventtype=" + eventtype + "]";
	}
}
