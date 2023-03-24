package com.demo.EventManagementPortal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.demo.EventManagementPortal.beans.User;
import com.demo.EventManagementPortal.dao.UserDao;

@Service
public class UserPrincipalDetailService implements UserDetailsService{
	
	@Autowired
	private UserDao udao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = udao.findByEmail(username);
		UserPrincipal userPrincipal = new UserPrincipal(user);
		return userPrincipal;
	}
}
