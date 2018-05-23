package com.chetan.stock.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chetan.stock.dao.StockDao;
import com.chetan.stock.model.Stock;
import com.chetan.util.CustomHibernateDaoSupport;

@Repository("stockDao")
public class StockDaoImpl  extends CustomHibernateDaoSupport implements StockDao{

	public void save(Stock stock){
		getHibernateTemplate().save(stock);
	}
	

	@Transactional 
	public void update(Stock stock){
		getHibernateTemplate().update(stock);
	}
	

	@Transactional 
	public void delete(Stock stock){
		getHibernateTemplate().delete(stock);
	}
	
	public Stock findByStockCode(String stockCode){
		List list = getHibernateTemplate().find(
                     "from Stock where stockCode=?",stockCode
                );
		return (Stock)list.get(0);
	}

}
