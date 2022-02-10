package com.cap.capconnect.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.cap.capconnect.entity.Answer;
import com.cap.capconnect.entity.Query;

@Repository
public interface IAnswerRepository extends JpaRepository<Answer,Long>{



	public List<Answer> findByQuery(Query query);
	//@Query("select  a from answer a where a.query in (select q from query q where q.post_id=:post_id)")
	//List<Answer> findBypostId(@Param("post_id")long post_id);
}
