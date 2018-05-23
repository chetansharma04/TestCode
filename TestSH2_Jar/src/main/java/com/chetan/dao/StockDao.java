package com.chetan.dao;

import com.chetan.model.Stock;

public interface StockDao {
	
	void save(Stock stock);
	void update(Stock stock);
	void delete(Stock stock);
	Stock findByStockCode(String stockCode);

}