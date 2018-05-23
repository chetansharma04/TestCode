package com.chetan.spring.transactionMgmt.tm2.bo.boImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chetan.spring.transactionMgmt.tm2.bo.ProductBo;
import com.chetan.spring.transactionMgmt.tm2.dao.daoImpl.ProductDaoImpl;
import com.chetan.spring.transactionMgmt.tm2.model.Product;
import com.chetan.spring.transactionMgmt.tm2.model.ProductQoh;

@Service
public class ProductBoImpl implements ProductBo{
	@Autowired
	ProductDaoImpl productDao;
	
	@Autowired
	ProductQohBoImpl productQohBo;

	//this method need to be transactional
//	@Transactional
	public void save(Product product, int qoh){

		productDao.save(product);
		System.out.println("Product Inserted");

		ProductQoh productQoh = new ProductQoh();
		productQoh.setProductId(product.getProductId());
		productQoh.setQty(qoh);

		productQohBo.save(productQoh);
		System.out.println("ProductQoh Inserted");
	}
}
