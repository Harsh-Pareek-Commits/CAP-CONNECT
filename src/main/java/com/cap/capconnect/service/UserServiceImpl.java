package com.cap.capconnect.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cap.capconnect.entity.User;
import com.cap.capconnect.exception.UserNotFoundException;
import com.cap.capconnect.repository.IUserRepository;
import com.cap.capconnect.security.JwtUtil;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

	Logger log = LoggerFactory.getLogger(QueryServiceImpl.class);
	@Autowired
	IUserRepository userRepository;
	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private PasswordEncoder passwordEncoder;

	// add
	@Override
	public User addUser(User user) throws UserNotFoundException {
		Optional<User> opt = null;
		try {
			opt = userRepository.findByEmail(user.getEmail());
			if (opt.isPresent()) {
				throw new UserNotFoundException("User name already exists");
			} else {

				if (user.getPassword() != null) {
					String securePassword = passwordEncoder.encode(user.getPassword());
					user.setPassword(securePassword);

					return userRepository.save(user);
				} else {
					throw new UserNotFoundException("Please Enter Password");
				}

			}
		} catch (Exception e) {
			throw new UserNotFoundException("User cannot be added");
		}
	}

	@Override
	public User deleteUser(long user_id) throws UserNotFoundException {
		try {
			Optional<User> opt = userRepository.findById(user_id);
			if (opt.isPresent()) {
				userRepository.deleteById(user_id);
				return opt.get();

			} else {
				throw new UserNotFoundException("User not found in delete");
			}

		} catch (Exception e) {

			throw new UserNotFoundException("User not found in delete");

		}
	}

	@Override
	public User updateUser(User user, long user_id) throws UserNotFoundException {

		if (userRepository.findById(user_id).isPresent()) {
			User existingUser = userRepository.findById(user_id).get();

			existingUser.setName(user.getName());
			existingUser.setDesignation(user.getDesignation());
			existingUser.setEmail(user.getEmail());
			existingUser.setPassword(user.getPassword());

			User updatedUser = userRepository.save(existingUser);

			return new User(updatedUser.getUser_id(), updatedUser.getName(), updatedUser.getDesignation(),
					updatedUser.getEmail(), updatedUser.getPassword());
		} else {
			throw new UserNotFoundException("Category cannot be added");

		}
	}
	// view

	@Override
	public List<User> viewUser() {

		List<User> userList = null;
		try {

			userList = userRepository.findAll();

		} catch (Exception e) {

			log.error("View user Exception:", e);
		}

		return userList;
	}

	// view by id
	@Override
	public User viewUserById(long user_id) throws UserNotFoundException {

		User user = null;
		try {
			Optional<User> opt = userRepository.findById(user_id);
			if (opt.isPresent()) {
				user = opt.get();
			} else {
				throw new UserNotFoundException("User id not found in view query by id");
			}
		} catch (Exception e) {

			throw new UserNotFoundException("User id not found in view query by id");
		}
		return user;
	}

	@Override
	public String signIn(User user) throws UserNotFoundException {
	try {

		System.out.println(user.getPassword());	
			this.authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
			
	} catch (Exception e) {
        log.trace(e+"");
			//throw new UserNotFoundException("Invalid Credential");
		}
		UserDetails userdetail = this.loadUserByUsername(user.getEmail());
		System.out.println(userdetail);
		String token =this.jwtutil.generateToken(userdetail);
		return token;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(email).get();

		String role = "admin";

		Set auth = new HashSet<>();

		auth.add(new SimpleGrantedAuthority(role));

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), auth);

	}

	@Override
	public User getUser(User user) {
		User user1 = userRepository.findByEmail(user.getEmail()).get();
		return user1;
	}

	@Override
	public User signOut(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
