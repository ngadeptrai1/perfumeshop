package com.edu.shop.model;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;


/**
 * The persistent class for the discount_details database table.
 * 
 */
@Entity
@Table(name="discount_details")
@NamedQuery(name="DiscountDetail.findAll", query="SELECT d FROM DiscountDetail d")
@Data
public class DiscountDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int attribute;

	@Column(name="end_date")
	private Date endDate;

	private int quantity;

	@Column(name="start_date")
	private Date startDate;

	//bi-directional many-to-one association to Discount
	@OneToOne(mappedBy = "discountDetails",fetch = FetchType.LAZY)
	private Discount discount;

	//bi-directional many-to-one association to Perfume
	@OneToOne
	private Perfume perfume;



}