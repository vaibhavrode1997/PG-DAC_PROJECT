package com.demo.EventManagementPortal.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.demo.EventManagementPortal.beans.User;
import com.demo.EventManagementPortal.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	@Autowired(required=false)
	UserDao userDao;

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	//add user
	@Override
	public void registerUser(User user) {
		userDao.save(user);
	}

	//get user by id
	@Override
	public User getUserById(int userid) {
		Optional<User> op=userDao.findById(userid);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	//get all users 
	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	//update user
	@Override
	public int updateUser(User user) {
		Optional<User> op=userDao.findById(user.getUserid());
		if(op.isPresent()) {
			User user1=op.get();
			user1.setAddress(user.getAddress());
			user1.setCity(user.getCity());
			user1.setContactnumber(user.getContactnumber());
			user1.setEmail(user1.getEmail());
			user1.setFirstname(user.getFirstname());
			user1.setLastname(user.getLastname());
			user1.setPassword(user.getPassword());
			user1.setPincode(user.getPincode());
			user1.setReenterpassword(user.getReenterpassword());
			user1.setRole(user.getRole());
			user1.setState(user.getState());
			userDao.save(user1);
			return 1;
		}
		return 0;
	}

	//delete user
	@Override
	public boolean deleteUser(int userid) {
		Optional<User> op=userDao.findById(userid);
		if(op.isPresent()) {
			userDao.deleteById(userid);
			return true;
		}
		return false;
	}

	//find by email
	@Override
	public User findByEmail(String email) {
		
		return userDao.findByEmail(email);
	}

	//save method
	@Override
	public void save(User user) {
		
		userDao.save(user);
	}
	

}
