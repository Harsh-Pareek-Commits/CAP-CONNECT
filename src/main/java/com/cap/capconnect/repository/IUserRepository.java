package com.cap.capconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.capconnect.entity.User;

public interface IUserRepository extends JpaRepository<User,Long> {
	

}
