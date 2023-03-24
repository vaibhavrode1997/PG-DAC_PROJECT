package com.demo.EventManagementPortal.beans;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="dateandtime")
public class DateTime {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dateandtimeid;
	
	private String startdate;
	
	private String enddate;
	
	private String starttime;
	
	private String endtime;

	//relation between datetime and order
	@OneToOne(mappedBy = "datetime", fetch = FetchType.LAZY)
	private Order order;

	public DateTime() {
		super();
	}

	public DateTime(String startdate, String enddate, String starttime, String endtime) {
		super();
		this.startdate = startdate;
		this.enddate = enddate;
		this.starttime = starttime;
		this.endtime = endtime;
	}

	//getter and setter
	public int getDateandtimeid() {
		return dateandtimeid;
	}


	public void setDateandtimeid(int dateandtimeid) {
		this.dateandtimeid = dateandtimeid;
	}


	public String getStartdate() {
		return startdate;
	}


	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}


	public String getEnddate() {
		return enddate;
	}


	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}


	public String getStarttime() {
		return starttime;
	}


	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}


	public String getEndtime() {
		return endtime;
	}


	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	//tostring
	@Override
	public String toString() {
		return "DateTime [dateandtimeid=" + dateandtimeid + ", startdate=" + startdate + ", enddate=" + enddate
				+ ", starttime=" + starttime + ", endtime=" + endtime + "]";
	}

}
