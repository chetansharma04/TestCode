package com.chetan.model;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StockDailyRecords", catalog = "dbo")
public class StockDailyRecords implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int stockDailyRecordId;
	private Date stockInDate;
	private Date stockOutDate;
	private Stock stock;
	
	public StockDailyRecords() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "stockDailyRecordId", unique = true, nullable = false)
	public Integer getStockDailyRecordId() {
		return this.stockDailyRecordId;
	}

	public void setStockDailyRecordId(Integer stockDailyRecordId) {
		this.stockDailyRecordId = stockDailyRecordId;
	}


	@ManyToOne (fetch= FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name = "STOCKID")
	public Stock getStock() {
		return stock;
	}


	public void setStock(Stock stock) {
		this.stock = stock;
	}


	public Date getStockInDate() {
		return stockInDate;
	}


	public void setStockInDate(Date stockInDate) {
		this.stockInDate = stockInDate;
	}


	public Date getStockOutDate() {
		return stockOutDate;
	}


	public void setStockOutDate(Date stockOutDate) {
		this.stockOutDate = stockOutDate;
	}


	@Override
	public String toString() {
		return "StockDailyRecords [stockDailyRecordId=" + stockDailyRecordId + ", stockInDate=" + stockInDate
				+ ", stockOutDate=" + stockOutDate + "]";
	}

}