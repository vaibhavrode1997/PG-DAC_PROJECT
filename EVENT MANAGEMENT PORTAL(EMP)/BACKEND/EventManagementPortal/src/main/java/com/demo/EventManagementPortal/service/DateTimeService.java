package com.demo.EventManagementPortal.service;
import java.util.List;
import com.demo.EventManagementPortal.beans.DateTime;

public interface DateTimeService {
	//add dateTime
	void addDateTime(DateTime dateTime);

	//getdateTime by id
	DateTime getDateTimeById(int dateTimeid);

	//get all dateTimes 
	List<DateTime> getAllDateTimes();

	//update dateTime
	int updateDateTime(DateTime dateTime);

	//update dateTime
	boolean deletedateTime(int dateTimeid);
}
