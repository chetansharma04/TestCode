package com.chetan.spring.transactionMgmt.tm1.dao.daoImpl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.chetan.spring.transactionMgmt.tm1.dao.ProductQohDao;
import com.chetan.spring.transactionMgmt.tm1.model.ProductQoh;

public class ProductQohDaoImpl extends HibernateDaoSupport implements ProductQohDao{
	
	public void save(ProductQoh productQoh){
		getHibernateTemplate().save(productQoh);
	}
	
}