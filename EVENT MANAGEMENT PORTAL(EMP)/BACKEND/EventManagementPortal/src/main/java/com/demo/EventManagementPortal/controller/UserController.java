package com.demo.EventManagementPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.EventManagementPortal.beans.User;
import com.demo.EventManagementPortal.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UserController 
{
	@Autowired(required=false)
	UserService userService;

	//add user
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/users")
	public ResponseEntity<User> registerUser(@RequestBody User user)
	{
		userService.registerUser(user);
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	} 

	//getUser by id
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/users/{userid}")
	public ResponseEntity<User> getUserById(@PathVariable int userid) {
		User user =userService.getUserById(userid);
		if(user!=null) {
			return new ResponseEntity(user,HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	//get all users 
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> userlist=userService.getAllUsers();
		return ResponseEntity.ok(userlist);
	}

	//update user
	@PutMapping("/users")
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		int n=userService.updateUser(user);
		if(n>0)
			return new ResponseEntity<String>("user updated successfully "+user,HttpStatus.CREATED);
		else
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	//delete user
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/users/{userid}")
	public ResponseEntity<String> deleteUser(@PathVariable int userid) {
		boolean status=userService.deleteUser(userid);
		if(status)
			return new ResponseEntity<String>("user deleted successfully "+ userid,HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

	//get user for login
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/login")
	public ResponseEntity<User> getUserForValidation(@RequestBody User user1) {
		List<User> userList= userService.getAllUsers();
		for(User user:userList)
		{
			if(user.getEmail().equals(user1.getEmail()) && user.getPassword().equals(user1.getPassword()))
			{
				return new ResponseEntity(user,HttpStatus.OK);
			}
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}
