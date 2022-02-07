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

import com.cap.capconnect.entity.Category;
import com.cap.capconnect.entity.Query;
import com.cap.capconnect.exception.CategoryNotFoundException;
import com.cap.capconnect.exception.QueryNotFoundException;
import com.cap.capconnect.service.IQueryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/query")

public class QueryController {
	@Autowired
	IQueryService queryService;
	
		@PostMapping("/add")
		public ResponseEntity<Query> addQuery(@Valid @RequestBody Query query) throws QueryNotFoundException {
			 
			return new ResponseEntity<>(this.queryService.addQuery(query), HttpStatus.OK);
			 
		}	
		@GetMapping("/view")
		public ResponseEntity<List<Query>> viewQuery() throws QueryNotFoundException {
			return new ResponseEntity<>(this.queryService.viewQuery(), HttpStatus.OK);
		}
		
		
		@GetMapping("/view/{post_id}")
		public ResponseEntity<Query> viewQueryById(@PathVariable("post_id")long post_id) throws QueryNotFoundException
		{ 
			return new ResponseEntity<>( this.queryService.viewQueryById(post_id), HttpStatus.OK);
		}
		@DeleteMapping("/delete/{post_id}")
		
		public ResponseEntity<Query> deleteQuery(@PathVariable(value = "post_id") long post_id) throws QueryNotFoundException {
			return new ResponseEntity<>(this.queryService.deleteQuery(post_id), HttpStatus.OK);
		}
		@PutMapping("/update/{post_id}")
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<Query> updateQuery(@PathVariable(value = "post_id") long post_id,
	                                                         @RequestBody Query query) throws QueryNotFoundException{
	        return new ResponseEntity<>(queryService.updateQuery(query,post_id), HttpStatus.OK);
	    }

}