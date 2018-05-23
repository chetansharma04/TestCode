package com.chetan.spring.transactionMgmt.tm2.bo.boImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chetan.spring.transactionMgmt.tm2.bo.ProductQohBo;
import com.chetan.spring.transactionMgmt.tm2.model.ProductQoh;

@Service
public class ProductQohBoImpl {

	@Transactional
	public void save(ProductQoh productQoh) {
		
	}


	
}
