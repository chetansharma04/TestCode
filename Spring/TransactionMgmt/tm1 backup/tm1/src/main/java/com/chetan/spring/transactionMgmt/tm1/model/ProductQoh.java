package com.chetan.spring.transactionMgmt.tm1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_qoh")
public class ProductQoh implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "QOH_ID", unique = true)
	private Long qohId;
	
	@Column(name = "PRODUCT_ID")
	private long productId;
	
	@Column(name = "QTY")
	private int qty;

	public ProductQoh() {
	}

	public ProductQoh(long productId, int qty) {
		this.productId = productId;
		this.qty = qty;
	}

	public Long getQohId() {
		return this.qohId;
	}

	public void setQohId(Long qohId) {
		this.qohId = qohId;
	}

	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
