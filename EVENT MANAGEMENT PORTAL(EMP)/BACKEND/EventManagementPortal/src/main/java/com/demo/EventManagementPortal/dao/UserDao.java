package com.demo.EventManagementPortal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.EventManagementPortal.beans.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByEmail(String email);

}
