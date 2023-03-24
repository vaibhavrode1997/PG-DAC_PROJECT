package com.demo.EventManagementPortal.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int feedbackid;
	private String email;
	private String subject;
	private String message;
	
	//constructor
	public Feedback() {
		super();
	}

	public Feedback(String email, String subject, String message) {
		super();
		this.email = email;
		this.subject = subject;
		this.message = message;
	}
	//getter and setter
	public String getEmail() {
		return email;
	}

	public int getFeedbackid() {
		return feedbackid;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	//tostring
	@Override
	public String toString() {
		return "Feedback [feedbackid=" + feedbackid + ", email=" + email + ", subject=" + subject + ", message="
				+ message + "]";
	}
		
}
