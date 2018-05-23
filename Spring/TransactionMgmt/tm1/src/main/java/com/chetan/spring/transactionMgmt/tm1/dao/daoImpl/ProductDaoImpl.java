package com.chetan.spring.transactionMgmt.tm1.dao.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chetan.spring.transactionMgmt.tm1.model.Product;

@Repository
public class ProductDaoImpl extends HibernateDaoSupport {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
    public void anyMethodName(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
    }
	
//	@Override
	public void save(Product product) {

		sessionFactory.getCurrentSession().save(product);
		
	}

}
