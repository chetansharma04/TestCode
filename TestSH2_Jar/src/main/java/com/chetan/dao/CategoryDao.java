package com.chetan.dao;

import java.util.List;

import com.chetan.model.Category;

public interface CategoryDao {
	
	void save(Category category);
	void update(Category category);
	void delete(Category category);
	List<Category> findAllCategory();

}
