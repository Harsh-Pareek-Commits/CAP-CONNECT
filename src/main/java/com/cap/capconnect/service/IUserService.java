package com.cap.capconnect.service;


import java.util.List;
import com.cap.capconnect.entity.User;
import com.cap.capconnect.exception.UserNotFoundException;

public interface IUserService {
	
	public  User  addUser(User user) throws UserNotFoundException;
	public User  deleteUser(long query_id)throws UserNotFoundException;
	public User updateUser(User user, long user_id) throws UserNotFoundException;
	public  List<User> viewUser() throws UserNotFoundException;
	public User viewUserById(long user_id)  throws UserNotFoundException;
}
