package com.chetan.spring.transactionMgmt.tm2.bo;

import org.springframework.stereotype.Service;

import com.chetan.spring.transactionMgmt.tm2.model.ProductQoh;

@Service
public interface ProductQohBo {
	
	public void save(ProductQoh productQoh);

}
