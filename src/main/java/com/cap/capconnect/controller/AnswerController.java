package com.cap.capconnect.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cap.capconnect.entity.Answer;
import com.cap.capconnect.exception.AnswerNotFoundException;
import com.cap.capconnect.service.IAnswerService;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/answer")
public class AnswerController {
	
	@Autowired
	IAnswerService answerService;
	
		@PostMapping("/add")
		public Answer addAnswer(@Valid @RequestBody Answer answer) throws AnswerNotFoundException {
			 
			return this.answerService.addAnswer(answer);
			 
		}	
		@GetMapping("/view")
		public List<Answer> viewAnswer() throws AnswerNotFoundException {
			return this.answerService.viewAnswer();
		}
		
		
		@GetMapping("/view/ans_id}")
		public Answer viewAnswerById(@PathVariable("ans_id")long ans_id) throws AnswerNotFoundException
		{ 
			return this.answerService.viewAnswerById(ans_id);
		}
		@DeleteMapping("/delete/{ans_id}")
		@ResponseBody
		public Answer deleteAnswer(@PathVariable(value = "ans_id") long ans_id) throws AnswerNotFoundException {
			return this.answerService.deleteAnswer(ans_id);
		}
		@PutMapping("/update/{post_id}")
		public Answer updateAnswer(@Valid @RequestBody Answer answer,@PathVariable("ans_id")long ans_id) throws AnswerNotFoundException
		{
			
			Answer existingAnswer= this.updateAnswer(answer, ans_id);
			return existingAnswer;
		}



}
