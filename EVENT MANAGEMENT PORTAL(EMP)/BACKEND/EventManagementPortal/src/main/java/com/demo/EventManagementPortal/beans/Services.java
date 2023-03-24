package com.demo.EventManagementPortal.beans;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="services")
public class Services {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serviceid;
	private String servicename;
	@NotNull
	private String servicetype;
	@NotNull
	private String location;
	@NotNull
	private String owner;
	@Lob
	private byte[] image;
	
	//relation between service and user
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="userid")
	private User user=new User();
	
	//relation between service and event
	@ManyToMany(mappedBy = "servicelist",fetch = FetchType.EAGER)
	private List<Event> eventlist;
	
//	//relation between service and hall
//	@OneToOne(mappedBy ="service")
//	Hall hall;
	
//	//relation between service and Caterer
//	@OneToMany(mappedBy ="service")
//	List<Caterer> catererlist;
//	
//	//relation between service and photography
//	@OneToMany(mappedBy ="service")
//	List<Photography> photographylist;
//	
//
//	//relation between service and musicsystem
//	@OneToMany(mappedBy ="service")
//	List<Musicsystem> musicsystemlist;
//	
//
//	//relation between service and Horse
//	@OneToMany(mappedBy ="service")
//	List<Horse> horselist;
//	
//
//	//relation between service and watersupply
//	@OneToMany(mappedBy ="service")
//	List<WaterSupply> watersupplylist;
//
//	//relation between service and transportation
//	@OneToMany(mappedBy ="service")
//	List<Transportation> transportationlist;
//
//	//relation between service and decoration
//	@OneToMany(mappedBy ="service")
//	List<Decoration> decorationlist;
//
//	//relation between service and firecrackers
//	@OneToMany(mappedBy ="service")
//	List<FireCrackers> firecrackerslist;
//
//	//relation between service and poojavidhi
//	@OneToMany(mappedBy ="service")
//	List<PoojaVidhi> poojavidhilist;
	
	//constructor
	public Services() {
		super();
	}

	public Services(String servicename, String servicetype,String location,String owner) {
		super();
		this.servicename = servicename;
		this.servicetype = servicetype;
		this.location = location;
		this.owner=owner;
	}

	//getter and setter
	
	public int getServiceid() {
		return serviceid;
	}

	public List<Event> getEventlist() {
		return eventlist;
	}

	public void setEventlist(List<Event> eventlist) {
		this.eventlist = eventlist;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public String getServicetype() {
		return servicetype;
	}

	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
//	public User getUserlist() {
//		return user;
//	}
//
//	public void setUserlist(User userlist) {
//		this.user = userlist;
//	}

//	public List<Event> getEvent() {
//		return eventlist;
//	}
//
//	public void setEvent(List<Event> event) {
//		this.eventlist = event;
//	}

	//tostring
	@Override
	public String toString() {
		return "Service [serviceid=" + serviceid + ", servicename=" + servicename + ", servicetype=" + servicetype
				+ ", location=" + location + ", owner=" + owner + "]";
	}
	
}
