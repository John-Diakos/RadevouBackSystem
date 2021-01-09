package com.back.controller;

import com.back.dao.UserDao;
//import com.back.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.back.service.JwtUserDetailsService;


import com.back.config.JwtTokenUtil;
import com.back.model.JwtRequest;
import com.back.model.UserDTO;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDao userDao;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		System.out.println(authenticationRequest);
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);


		return ResponseEntity.ok(
				new UserDTO(
						userDao.findByUsername(authenticationRequest.getUsername()).getId(),
						userDao.findByUsername(authenticationRequest.getUsername()).getFirstName(),
						userDao.findByUsername(authenticationRequest.getUsername()).getLastName(),
						userDao.findByUsername(authenticationRequest.getUsername()).getEmail(),
						authenticationRequest.getUsername(),
						authenticationRequest.getPassword(),
						userDao.findByUsername(authenticationRequest.getUsername()).getAge(),
						userDao.findByUsername(authenticationRequest.getUsername()).getBirthDay(),
						userDao.findByUsername(authenticationRequest.getUsername()).getRole(),
						userDao.findByUsername(authenticationRequest.getUsername()).isActivate(),
						userDao.findByUsername(authenticationRequest.getUsername()).isSuperior(),
						userDao.findByUsername(authenticationRequest.getUsername()).getDepartment(),
						token)
				); //ResponseEntity.ok(new JwtResponse(token)
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}