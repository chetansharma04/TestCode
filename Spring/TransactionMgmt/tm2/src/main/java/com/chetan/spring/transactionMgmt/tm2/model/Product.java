package com.chetan.spring.transactionMgmt.tm2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "product_code")
	private String productCode;
	
	@Column(name = "product_desc")
	private String productDesc;

	public Product() {
	}

	public Product(String productCode, String productDesc) {
		this.productCode = productCode;
		this.productDesc = productDesc;
	}


	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductDesc() {
		return this.productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
}
