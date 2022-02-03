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
import org.springframework.web.bind.annotation.RestController;

import com.cap.capconnect.entity.Category;
import com.cap.capconnect.exception.CategoryNotFoundException;
import com.cap.capconnect.service.ICategoryService;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	ICategoryService categoryService;
	
		@PostMapping("/add")
		public  ResponseEntity<Category> addCategory(@Valid @RequestBody Category category) throws CategoryNotFoundException {
			return new ResponseEntity<>(this.categoryService.addCategory(category), HttpStatus.OK);
		
			 
		}	
		@GetMapping("/view")
		public List<Category> viewCategory() throws CategoryNotFoundException {
			return this.categoryService.viewCategory();
		}
		
		
	/*
	 * @GetMapping("/view/cate_name}") public Category
	 * viewCategoryById(@PathVariable("cate_name") String cate_name) throws
	 * CategoryNotFoundException { return
	 * this.categoryService.viewCategoryByName(cate_name); }
	 */
		
		@DeleteMapping("/delete/{cate_id}")
		@ResponseBody
		public Category deleteCategory(@PathVariable(value = "cate_id") long cate_id) throws CategoryNotFoundException {
			return this.categoryService.deleteCategory(cate_id);
		}
		
		@PutMapping("/update/{cate_id}")
		public Category updateCategory(@Valid @RequestBody Category category,@PathVariable("cate_id")long cate_id) throws CategoryNotFoundException
		{
			
			Category existingCategory= this.updateCategory(category, cate_id);
			return existingCategory;
		}


}
