package com.cap.capconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.capconnect.entity.Query;

public interface IQueryRepository extends JpaRepository<Query,Long> {
	

}
