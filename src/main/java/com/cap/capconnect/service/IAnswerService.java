package com.cap.capconnect.service;

import com.cap.capconnect.entity.Answer;

public interface IAnswerService {
	

	public  Answer  addAnswer(Answer answer);
	public Answer deleteAnswer(long ans_id);
	public Answer updateAnswer(Answer answer);
	public Answer approveAnswer(long ans_id);
	

}
