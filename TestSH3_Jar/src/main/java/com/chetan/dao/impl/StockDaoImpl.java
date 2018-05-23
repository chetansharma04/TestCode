package com.chetan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chetan.dao.StockDao;
import com.chetan.model.Stock;
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
		@SuppressWarnings("unchecked")
		List<Stock> list = (List<Stock>) getHibernateTemplate().find(
                     "from Stock where stockCode=?",stockCode
                );
		return (Stock)list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<Stock> findAll(){
		return (List<Stock>) getHibernateTemplate().find("from Stock");
	}
	



}
