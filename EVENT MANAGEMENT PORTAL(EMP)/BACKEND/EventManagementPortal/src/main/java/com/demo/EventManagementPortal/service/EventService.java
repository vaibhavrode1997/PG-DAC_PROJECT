package com.demo.EventManagementPortal.service;

import java.util.List;

import com.demo.EventManagementPortal.beans.Event;

public interface EventService 
{
	//add event
	public void addEvent(Event event);

	//displayEvent by id
	public Event getEventById(int eventid);

	//display all events
	public List<Event> getAllEvents();

	//update event
	public int updateEvent(Event event);

	//delete event
	public boolean deleteEvent(int eventid);
	
}
