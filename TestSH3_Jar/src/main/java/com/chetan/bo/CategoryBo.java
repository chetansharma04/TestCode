package com.chetan.bo;

import java.util.List;

import com.chetan.model.Category;

public interface CategoryBo {
	
	void save(Category category);
	void update(Category category);
	void delete(Category category);
	List<Category> findAllCategory();
}