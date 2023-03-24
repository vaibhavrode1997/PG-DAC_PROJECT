package com.demo.EventManagementPortal.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.EventManagementPortal.beans.DateTime;
import com.demo.EventManagementPortal.dao.DateTimeDao;

@Service
public class DateTimeServiceImpl implements DateTimeService{

	@Autowired(required=false)
	DateTimeDao dateTimeDao;
	
	//add dateTime
	@Override
	public void addDateTime(DateTime dateTime) {
		dateTimeDao.save(dateTime);
	}

	//getdateTime by id
	@Override
	public DateTime getDateTimeById(int dateTimeid) {
		Optional<DateTime> op=dateTimeDao.findById(dateTimeid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	//get all dateTimes 
	@Override
	public List<DateTime> getAllDateTimes() {
		return dateTimeDao.findAll();
	}

	//update dateTime
	@Override
	public int updateDateTime(DateTime dateTime) {
		Optional<DateTime> op=dateTimeDao.findById(dateTime.getDateandtimeid());
		if(op.isPresent()) {
			DateTime dateTime1=op.get();
			dateTime1.setStartdate(dateTime.getStartdate());
			dateTime1.setEnddate(dateTime.getEnddate());
			dateTime1.setStarttime(dateTime.getStarttime());
			dateTime1.setEndtime(dateTime.getEndtime());
			dateTimeDao.save(dateTime1);
			return 1;
		}
		return 0;
	}

	//update dateTime
	@Override
	public boolean deletedateTime(int dateTimeid) {
		Optional<DateTime> op=dateTimeDao.findById(dateTimeid);
		if(op.isPresent()) {
			dateTimeDao.deleteById(dateTimeid);
			return true;
		}
		return false;
	}
}
