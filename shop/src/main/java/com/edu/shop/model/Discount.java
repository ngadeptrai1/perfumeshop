package com.edu.shop.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the discounts database table.
 * 
 */
@Entity
@Table(name="discounts")
@NamedQuery(name="Discount.findAll", query="SELECT d FROM Discount d")
public class Discount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "activated")
	private boolean activated;

	@Column(name = "name")
	private String name;

	//bi-directional many-to-one association to DiscountDetail
	@OneToOne
	@JoinColumn(name = "discount_detail_id")
	private DiscountDetail discountDetails;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="created_person_id",referencedColumnName = "id")
	private Account account;

	//bi-directional many-to-one association to Invoice
	@OneToOne
	private Invoice invoices;




}