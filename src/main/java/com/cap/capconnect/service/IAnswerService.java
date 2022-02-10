package com.cap.capconnect.service;

import java.util.List;

import com.cap.capconnect.entity.Answer;
import com.cap.capconnect.exception.AnswerNotFoundException;
import com.cap.capconnect.exception.QueryNotFoundException;
import com.cap.capconnect.entity.Query;

public interface IAnswerService {
	

	public  Answer  addAnswer(Answer answer) throws AnswerNotFoundException ;
	public Answer deleteAnswer(long ans_id) throws AnswerNotFoundException ;
	public Answer updateAnswer(Answer answer, long ans_id) throws AnswerNotFoundException ;
	public Answer approveAnswer(long ans_id)throws AnswerNotFoundException ;
	public List<Answer> viewAnswer() throws AnswerNotFoundException ;
	public Answer viewAnswerById(long ans_id)  throws AnswerNotFoundException;

	public List<Answer> viewAnswerBypostId(long post_id) throws AnswerNotFoundException;
	
}
