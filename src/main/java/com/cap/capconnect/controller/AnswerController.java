package com.cap.capconnect.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cap.capconnect.entity.Answer;
import com.cap.capconnect.entity.Query;
import com.cap.capconnect.exception.AnswerNotFoundException;
import com.cap.capconnect.exception.QueryNotFoundException;
import com.cap.capconnect.service.IAnswerService;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/answer")
public class AnswerController {
	
	@Autowired
	IAnswerService answerService;
	
		@PostMapping("/add")
		public ResponseEntity<Answer> addAnswer(@Valid @RequestBody Answer answer) throws AnswerNotFoundException {
			 
			return new ResponseEntity<>(this.answerService.addAnswer(answer),HttpStatus.OK);
			 
		}	
		@GetMapping("/view")
		public ResponseEntity<List<Answer>> viewAnswer() throws AnswerNotFoundException {
			return new ResponseEntity<>(this.answerService.viewAnswer(),HttpStatus.OK);
		}
		
		
		@GetMapping("/view/{ans_id}")
		public ResponseEntity<Answer> viewAnswerById(@PathVariable("ans_id")long ans_id) throws AnswerNotFoundException
		{ 
			return new ResponseEntity<>(this.answerService.viewAnswerById(ans_id),HttpStatus.OK);
		}
		@DeleteMapping("/delete/{ans_id}")
		@ResponseBody
		public  ResponseEntity<Answer> deleteAnswer(@PathVariable(value = "ans_id") long ans_id) throws AnswerNotFoundException {
			return new ResponseEntity<>(this.answerService.deleteAnswer(ans_id),HttpStatus.OK);
		}
		@PutMapping("/update/{ans_id}")
		@ResponseBody
		 @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<Answer> updateAnswer(@PathVariable(value = "ans_id") long ans_id,
	                                                         @RequestBody Answer answer) throws AnswerNotFoundException{
	        return new ResponseEntity<>(answerService.updateAnswer(answer,ans_id), HttpStatus.OK);
	    }



}
