package com.demo.EventManagementPortal.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="registration")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	
	@Column(nullable = false)
	@NotBlank(message = "user name can not be empty !!")
	@Size(min = 2, max = 20, message = "name must be between 2-20 characters !!")
	private String firstname;
	
	@Column(nullable = false)
	@NotBlank(message = "user name can not be empty !!")
	@Size(min = 2, max = 20, message = "name must be between 2-20 characters !!")
	private String lastname;
	
	@Email
	@Column(nullable = false,unique = true)
	private String email;
	
	@NotNull
	private String password;
	
	@NotNull
	private String reenterpassword;
	
	@NotNull
	private String role;

	@Temporal(TemporalType.DATE)
	private Date registerdate=new java.sql.Date(new java.util.Date().getTime());

	private String address;
	private String contactnumber;
	private int pincode;
	private String city;
	private String state;

	//relation between user and service
	@OneToMany(mappedBy="user",orphanRemoval = true,cascade=CascadeType.ALL)
	private List<Services> servicelist;

	//Constructor
	public User() {
		super();
	}

	public User(@NotNull String firstname, @NotNull String lastname, @NotNull String email, @NotNull String password,
			@NotNull String role, Date registerdate, String address, String contactnumber, int pincode, String city,
			String state, @NotNull String reenterpassword) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.role = role;
		this.registerdate = registerdate;
		this.address = address;
		this.contactnumber = contactnumber;
		this.pincode = pincode;
		this.city = city;
		this.state = state;
		this.reenterpassword = reenterpassword;
	}



	//getter setter
	public int getUserid() {
		return userid;
	}

	public String getFirstname() {
		return firstname;
	}
	//
	//	public List<Services> getServicelist() {
	//		return servicelist;
	//	}
	//
	//	public void setServicelist(List<Services> servicelist) {
	//		this.servicelist = servicelist;
	//	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getReenterpassword() {
		return reenterpassword;
	}

	public void setReenterpassword(String reenterpassword) {
		this.reenterpassword = reenterpassword;
	}

	//tostring;
	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", reenterpassword=" + reenterpassword + ", role=" + role
				+ ", registerdate=" + registerdate + ", address=" + address + ", contactnumber=" + contactnumber
				+ ", pincode=" + pincode + ", city=" + city + ", state=" + state + "]";
	}

}
