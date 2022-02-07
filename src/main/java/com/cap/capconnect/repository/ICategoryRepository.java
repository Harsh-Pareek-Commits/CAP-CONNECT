package com.cap.capconnect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.capconnect.entity.Category;
import com.cap.capconnect.entity.User;
@Repository
public interface ICategoryRepository extends JpaRepository<Category,Long>{
	
}
