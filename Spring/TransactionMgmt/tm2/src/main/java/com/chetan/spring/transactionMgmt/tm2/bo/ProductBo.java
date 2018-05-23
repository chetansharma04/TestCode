package com.chetan.spring.transactionMgmt.tm2.bo;

import org.springframework.stereotype.Service;

import com.chetan.spring.transactionMgmt.tm2.model.Product;

@Service
public interface ProductBo {

	//this method need to be transactional
		public void save(Product product, int qoh);
}
