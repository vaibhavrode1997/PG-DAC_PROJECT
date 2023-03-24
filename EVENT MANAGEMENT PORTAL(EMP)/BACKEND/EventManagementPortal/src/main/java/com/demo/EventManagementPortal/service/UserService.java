package com.demo.EventManagementPortal.service;

import java.util.List;

import com.demo.EventManagementPortal.beans.User;

public interface UserService
{
	//add user
	public void registerUser(User user);

	//get user by id
	public User getUserById(int userid);

	//get all users 
	public List<User> getAllUsers();

	//update user
	public int updateUser(User user);

	//delete user
	public boolean deleteUser(int userid);
	
	//find by email
	public User findByEmail(String email);

	//save method
	public void save(User user);

}
