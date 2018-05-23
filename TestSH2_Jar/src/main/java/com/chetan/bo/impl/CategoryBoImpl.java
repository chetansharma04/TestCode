package com.chetan.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chetan.bo.CategoryBo;
import com.chetan.dao.CategoryDao;
import com.chetan.model.Category;



@Service("categoryBo")
public class CategoryBoImpl implements CategoryBo{
	
	@Autowired
	CategoryDao categoryDao;
	
	public void setCategoryDao(CategoryDao CategoryDao) {
		this.categoryDao = CategoryDao;
	}

	@Transactional 
	public void save(Category category){
		categoryDao.save(category);
	}
	
	public void update(Category Category){
		categoryDao.update(Category);
	}
	
	public void delete(Category Category){
		categoryDao.delete(Category);
	}
	
	public List<Category> findAllCategory(){
		return categoryDao.findAllCategory();
	}
}