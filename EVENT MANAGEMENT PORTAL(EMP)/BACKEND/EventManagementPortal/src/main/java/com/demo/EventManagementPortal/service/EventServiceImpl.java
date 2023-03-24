package com.demo.EventManagementPortal.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.EventManagementPortal.beans.Event;
import com.demo.EventManagementPortal.dao.EventDao;

@Service
public class EventServiceImpl implements EventService
{
	@Autowired(required=false)
	EventDao eventDao;

	//add event
	@Override
	public void addEvent(Event event) {
		eventDao.save(event);
	}

	//getEvent by id
	@Override
	public Event getEventById(int eventid) {
		Optional<Event> op=eventDao.findById(eventid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	//get all events
	@Override
	public List<Event> getAllEvents() {
		return eventDao.findAll();
	}

	//update event
	@Override
	public int updateEvent(Event event) 
	{
		Optional<Event> op=eventDao.findById(event.getEventid());
		if(op.isPresent()) {
			Event event1=op.get();
			event1.setEventtype(event.getEventtype());
			eventDao.save(event1);
			return 1;
		}
		return 0;
	}

	//delete event
	@Override
	public boolean deleteEvent(int eventid) 
	{
		Optional<Event> op=eventDao.findById(eventid);
		if(op.isPresent()) {
			eventDao.deleteById(eventid);
			return true;
		}
		return false;
	}
}
