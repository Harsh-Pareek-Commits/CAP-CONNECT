package com.cap.capconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.capconnect.entity.Category;
@Repository
public interface ICategoryRepository extends JpaRepository<Category,Long>{

}
