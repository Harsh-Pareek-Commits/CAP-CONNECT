package com.cap.capconnect.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cap.capconnect.entity.Category;
import com.cap.capconnect.entity.User;
import com.cap.capconnect.exception.CategoryNotFoundException;
import com.cap.capconnect.exception.UserNotFoundException;
import com.cap.capconnect.service.IUserService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")

public class UserController {
	@Autowired
	IUserService userService;
	
		@PostMapping("/add")
		public ResponseEntity<User> addUser(@Valid @RequestBody User user) throws UserNotFoundException {
			 
			return new ResponseEntity<>(this.userService.addUser(user),HttpStatus.OK);
			 
		}	
		@GetMapping("/view")
		public ResponseEntity<List<User>> viewUser() throws UserNotFoundException {
			return new ResponseEntity<>(this.userService.viewUser(),HttpStatus.OK);
		}
		
		@PutMapping("/update/{user_id}")
		public ResponseEntity<User> updateUser(@Valid @RequestBody User user,@PathVariable("user_id")long user_id) throws UserNotFoundException
		{
			
			ResponseEntity<User> existingUser= this.updateUser(user, user_id);
			return existingUser;
		}
		
		@DeleteMapping("/delete/{user_id}")
		@ResponseBody
		public ResponseEntity<User> deleteUser(@PathVariable(value = "user_id") long user_id) throws UserNotFoundException {
			return new ResponseEntity<>(this.userService.deleteUser(user_id),HttpStatus.OK);
		}
}