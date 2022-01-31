package com.cap.capconnect.service;


import com.cap.capconnect.entity.User;

public interface IUserService {
	
	public  User  addUser(User user);
	public User  deleteUser(long query_id);
	public User updateUser(User user);

}
