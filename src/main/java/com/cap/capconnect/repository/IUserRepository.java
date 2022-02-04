package com.cap.capconnect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.capconnect.entity.User;
@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
	Optional <User> findByEmail(String email);
	

}
