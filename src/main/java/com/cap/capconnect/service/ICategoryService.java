package com.cap.capconnect.service;

import java.util.List;

import com.cap.capconnect.entity.Category;
import com.cap.capconnect.exception.CategoryNotFoundException;

public interface ICategoryService {
	
	public  Category  addCategory(Category category) throws CategoryNotFoundException;
	public Category deleteCategory(long cate_id) throws CategoryNotFoundException ;
	public Category updateCategory(Category category) throws CategoryNotFoundException;
	public  List<Category> viewCategory() throws CategoryNotFoundException;
	public Category viewCategoryById(long cate_id)  throws CategoryNotFoundException;
	

}
