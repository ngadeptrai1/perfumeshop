package com.edu.shop.model.copy;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the perfume_price database table.
 * 
 */
@Entity
@Table(name="perfume_price")
@NamedQuery(name="PerfumePrice.findAll", query="SELECT p FROM PerfumePrice p")
public class PerfumePrice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="original_price")
	private BigDecimal originalPrice;

	@Column(name="purchase_price")
	private BigDecimal purchasePrice;

	@Column(name="sale_price")
	private BigDecimal salePrice;

	//bi-directional many-to-one association to Perfume
	@ManyToOne
	private Perfume perfume;

	public PerfumePrice() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getOriginalPrice() {
		return this.originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public BigDecimal getPurchasePrice() {
		return this.purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getSalePrice() {
		return this.salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public Perfume getPerfume() {
		return this.perfume;
	}

	public void setPerfume(Perfume perfume) {
		this.perfume = perfume;
	}

}