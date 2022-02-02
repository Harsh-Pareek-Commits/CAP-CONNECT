package com.cap.capconnect.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.capconnect.entity.Answer;
import com.cap.capconnect.exception.AnswerNotFoundException;
import com.cap.capconnect.repository.IAnswerRepository;
@Service
public class AnswerServiceImpl implements IAnswerService {

	  Logger log = LoggerFactory.getLogger(AnswerServiceImpl.class);
	  
	 @Autowired
	 IAnswerRepository answerRepository;

	
@Override
public  Answer addAnswer(Answer answer) throws AnswerNotFoundException  {
			Optional<Answer> opt = null;
			try {
				opt = answerRepository.findById(answer.getAns_id());
				if (opt.isPresent()) {
					throw new AnswerNotFoundException("Answer name already exists");}
				else
					return answerRepository.save(answer);
			} catch (Exception e) {
				throw new AnswerNotFoundException("Answer cannot be added");
			}
		}
	
@Override
public Answer deleteAnswer(long ans_id) throws AnswerNotFoundException {
	try {
		Optional<Answer> opt = answerRepository.findById(ans_id);
		if (opt.isPresent()) {
			answerRepository.deleteById(ans_id);
			return opt.get();

		} else {
			throw new AnswerNotFoundException("Answer not found in delete");
		}

	} catch (Exception e) {

		throw new AnswerNotFoundException("Answer not found in delete");

	}
}

@Override
public   Answer updateAnswer( Answer  answer) throws  AnswerNotFoundException {
	Optional< Answer> opt = null;
	try {
		opt = answerRepository.findById(answer.getAns_id());
		if (opt.isPresent()) {

			answerRepository.save(answer);
		} else {
			throw new AnswerNotFoundException(" Answer details not found");
		}
	} catch (Exception e) {
		
		throw new  AnswerNotFoundException(" Answer cannot be updated");
	}
	return opt.get();
}


	@Override
	public Answer approveAnswer(long ans_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Answer> viewAnswer() {

		List<Answer> answerList=null;
		try {

			answerList = answerRepository.findAll();

		} catch (Exception e) {

			log.error("View query Exception:", e);
		}

		return answerList;
	}


	@Override
	public Answer viewAnswerById(long ans_id) throws AnswerNotFoundException {
		
		Answer answer = null;
		try {
			Optional<Answer> opt = answerRepository.findById(ans_id);
			if (opt.isPresent()) {
				answer = opt.get();
			} else {
				throw new AnswerNotFoundException("Answer id not found in view answer by id");
			}
		} catch (Exception e) {

			throw new AnswerNotFoundException("Answer id not found in view answer by id");
		}
		return answer;
	}

}
