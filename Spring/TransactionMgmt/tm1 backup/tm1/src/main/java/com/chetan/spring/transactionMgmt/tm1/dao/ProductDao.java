package com.chetan.spring.transactionMgmt.tm1.dao;

import org.springframework.stereotype.Repository;

import com.chetan.spring.transactionMgmt.tm1.model.Product;

@Repository
public interface ProductDao {
	public void save(Product product);
}
