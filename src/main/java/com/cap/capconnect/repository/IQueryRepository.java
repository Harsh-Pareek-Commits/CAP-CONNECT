package com.cap.capconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.capconnect.entity.Query;
@Repository
public interface IQueryRepository extends JpaRepository<Query,Long> {
	

}
