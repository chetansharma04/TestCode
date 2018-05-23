package com.chetan.spring.transactionMgmt.tm1.bo;

import org.springframework.stereotype.Service;

import com.chetan.spring.transactionMgmt.tm1.model.ProductQoh;

@Service
public interface ProductQohBo {
	public void save(ProductQoh productQoh);

}
