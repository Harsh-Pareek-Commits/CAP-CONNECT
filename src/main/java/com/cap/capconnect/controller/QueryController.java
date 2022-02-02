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

import com.cap.capconnect.entity.Query;
import com.cap.capconnect.exception.QueryNotFoundException;
import com.cap.capconnect.service.IQueryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/query")

public class QueryController {
	@Autowired
	IQueryService queryService;
	
		@PostMapping("/add")
		public Query addQuery(@Valid @RequestBody Query query) throws QueryNotFoundException {
			 
			return this.queryService.addQuery(query);
			 
		}	
		@GetMapping("/view")
		public List<Query> viewQuery() throws QueryNotFoundException {
			return this.queryService.viewQuery();
		}
		
		
		@GetMapping("/view/post_id}")
		public Query viewQueryById(@PathVariable("post_id")long post_id) throws QueryNotFoundException
		{ 
			return this.queryService.viewQueryById(post_id);
		}
		@DeleteMapping("/delete/{post_id}")
		@ResponseBody
		public Query deleteQuery(@PathVariable(value = "post_id") long post_id) throws QueryNotFoundException {
			return this.queryService.deleteQuery(post_id);
		}
		@PutMapping("/update/{post_id}")
		public Query updateQuery(@Valid @RequestBody Query query,@PathVariable("post_id")long post_id) throws QueryNotFoundException
		{
			
			Query existingQuery= this.updateQuery(query, post_id);
			return existingQuery;
		}


}