package com.chetan.stock.bo;

import com.chetan.stock.model.Stock;

public interface StockBo {
	
	void save(Stock stock);
	void update(Stock stock);
	void delete(Stock stock);
	Stock findByStockCode(String stockCode);
}