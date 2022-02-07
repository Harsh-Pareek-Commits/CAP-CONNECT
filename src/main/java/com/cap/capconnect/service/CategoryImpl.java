package com.cap.capconnect.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.capconnect.entity.Category;
import com.cap.capconnect.exception.CategoryNotFoundException;
import com.cap.capconnect.repository.ICategoryRepository;
@Service
public class CategoryImpl implements ICategoryService {
	Logger log = LoggerFactory.getLogger(QueryServiceImpl.class);
	@Autowired
	 ICategoryRepository categoryRepository;
		@Override
		public Category addCategory(Category category) throws CategoryNotFoundException  {
					Optional<Category> opt = null;
					try {
						opt = categoryRepository.findById(category.getCate_id());
						if (opt.isPresent()) {
							throw new CategoryNotFoundException("Category name already exists");}
						else
							return categoryRepository.save(category);
					} catch (Exception e) {
						throw new CategoryNotFoundException("Category cannot be added");
					}
				}
		@Override
		public Category deleteCategory(long cate_id) throws CategoryNotFoundException {
			try {
				Optional<Category> opt = categoryRepository.findById(cate_id);
				if (opt.isPresent()) {
					categoryRepository.deleteById(cate_id);
					return opt.get();

				} else {
					throw new CategoryNotFoundException("Category not found in delete");
				}

			} catch (Exception e) {

				throw new CategoryNotFoundException("Category not found in delete");

			}
		}
		
				 @Override
				    public Category updateCategory(Category  category ,long cate_id) throws CategoryNotFoundException {

				        if (categoryRepository.findById(cate_id).isPresent()){
				        	Category existingCategory = categoryRepository.findById(cate_id).get();

				            existingCategory.setCate_name(category.getCate_name());
				            

				            Category updatedCategory = categoryRepository.save(existingCategory);

				            return new Category(updatedCategory.getCate_id(),
				                    updatedCategory.getCate_name());
				        }else{
								throw new CategoryNotFoundException("Category cannot be added");
							
				        }
				    }
		
				//view
				
				@Override
				public List<Category> viewCategory() {

					List<Category> categoryList=null;
					try {

						categoryList = categoryRepository.findAll();

					} catch (Exception e) {

						log.error("View query Exception:", e);
					}

					return categoryList;
				}
				
				//change to view by name
		//view by id
				@Override
				public Category viewCategoryById(long cate_id) throws CategoryNotFoundException {
					
					Category category = null;
					try {
						Optional<Category> opt = categoryRepository.findById(cate_id);
						if (opt.isPresent()) {
							category = opt.get();
						} else {
							throw new CategoryNotFoundException("Category id not found in view query by id");
						}
					} catch (Exception e) {

						throw new CategoryNotFoundException("Category id not found in view query by id");
					}
					return category;
				}
				

}
