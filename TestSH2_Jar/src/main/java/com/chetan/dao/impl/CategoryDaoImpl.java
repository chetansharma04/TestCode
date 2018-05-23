package com.chetan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chetan.dao.CategoryDao;
import com.chetan.model.Category;
import com.chetan.util.CustomHibernateDaoSupport;

@Repository("categoryDao")
public class CategoryDaoImpl  extends CustomHibernateDaoSupport implements CategoryDao{

	public void save(Category category){
		getHibernateTemplate().save(category);
	}

	@Transactional 
	public void update(Category category){
		getHibernateTemplate().update(category);
	}

	@Transactional 
	public void delete(Category category){
		getHibernateTemplate().delete(category);
	}
	
	public Category findByCategoryId(int categoryId){
		@SuppressWarnings("unchecked")
		List<Category> list = (List<Category>) getHibernateTemplate().find(
                     "from Category where categoryId=?",categoryId
                );
		return (Category)list.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Category> findAllCategory(){
		List<Category> list = (List<Category>) getHibernateTemplate().find("from Category");
		return list;
	}

}
