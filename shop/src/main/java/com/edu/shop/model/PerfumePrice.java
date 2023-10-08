package com.edu.shop.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;


/**
 * The persistent class for the perfume_price database table.
 * 
 */
@Entity
@Table(name="perfume_price")
@NamedQuery(name="PerfumePrice.findAll", query="SELECT p FROM PerfumePrice p")
@Data
public class PerfumePrice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name="original_price")
	private BigDecimal originalPrice;

	@Column(name="purchase_price")
	private BigDecimal purchasePrice;

	@Column(name="sale_price")
	private BigDecimal salePrice;

	//bi-directional many-to-one association to Perfume
	@OneToOne
	private Perfume perfume;



}