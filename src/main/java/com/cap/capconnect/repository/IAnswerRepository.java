package com.cap.capconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.capconnect.entity.Answer;
@Repository
public interface IAnswerRepository extends JpaRepository<Answer,Long>{

}
