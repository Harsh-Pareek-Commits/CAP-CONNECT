package com.cap.capconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.capconnect.entity.Category;

public interface ICategoryRepository extends JpaRepository<Category,Long>{

}