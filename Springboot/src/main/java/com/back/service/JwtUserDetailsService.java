package com.back.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.back.dao.UserDao;
import com.back.model.DAOUser;
import com.back.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOUser user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public DAOUser save(UserDTO user) throws ParseException {
		DAOUser newUser = new DAOUser();
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setAge(user.getAge());
		newUser.setBirthDay(user.getBirthDay());
		if(user.getRole().equals("admin")){
			newUser.setActivate(true);
		}else{
			newUser.setActivate(false);
		}
		newUser.setRole(user.getRole());
		newUser.setSuperior(user.isSuperior());
		newUser.setDepartment(user.getDepartment());

		return userDao.save(newUser);
	}

	public DAOUser update(UserDTO user) throws ParseException {
		DAOUser daoUser = userDao.findAllById(user.getId());
		daoUser.setFirstName(user.getFirstName());
		daoUser.setLastName(user.getLastName());
		daoUser.setEmail(user.getEmail());
		daoUser.setUsername(user.getUsername());
		daoUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		daoUser.setAge(user.getAge());
		daoUser.setBirthDay(user.getBirthDay());
		if(user.getRole().equals("admin")){
			daoUser.setActivate(true);
		}else{
			daoUser.setActivate(false);
		}
		daoUser.setRole(user.getRole());
		daoUser.setSuperior(user.isSuperior());
		daoUser.setDepartment(user.getDepartment());

		return userDao.save(daoUser);
	}

	public void delete(UserDTO user) {
		DAOUser newUser = userDao.findAllById(user.getId());
		userDao.delete(newUser);
	}

	public DAOUser activate(UserDTO user) throws ParseException {
		DAOUser daoUser = userDao.findAllById(user.getId());
		if(user.isActivate()){
			daoUser.setActivate(false);
		}else{
			daoUser.setActivate(true);
		}
		return userDao.save(daoUser);
	}

	public List<DAOUser> getUsers() {
		List<DAOUser> newUser = userDao.findAll();
		return newUser;
	}

	public DAOUser getUser(long id) throws ParseException {
		DAOUser newUser = userDao.findAllById(id);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		newUser.setBirthDay(sdf.parse(sdf.format(newUser.getBirthDay())));
		return newUser;
	}

	public List<DAOUser> getOnlyUser() {
		List<DAOUser> newUser = userDao.findAllByRole("user");
		return newUser;
	}

	public DAOUser getActivate(DAOUser user) {
		DAOUser newUser = userDao.findAllById(user.getId());
		newUser.setActivate(true);
		return userDao.save(newUser);
	}

	public DAOUser getDactivate(DAOUser user) {
		DAOUser newUser = userDao.findAllById(user.getId());
		newUser.setActivate(false);
		return userDao.save(newUser);
	}
}