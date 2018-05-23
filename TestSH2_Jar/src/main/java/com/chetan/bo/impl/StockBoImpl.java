package com.chetan.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chetan.bo.StockBo;
import com.chetan.dao.StockDao;
import com.chetan.model.Stock;

@Service("stockBo")
public class StockBoImpl implements StockBo{
	
	@Autowired
	StockDao stockDao;
	
	public void setStockDao(StockDao stockDao) {
		this.stockDao = stockDao;
	}

	@Transactional 
	public void save(Stock stock){
		stockDao.save(stock);
	}
	
	public void update(Stock stock){
		stockDao.update(stock);
	}
	
	public void delete(Stock stock){
		stockDao.delete(stock);
	}
	
	public Stock findByStockCode(String stockCode){
		return stockDao.findByStockCode(stockCode);
	}
}