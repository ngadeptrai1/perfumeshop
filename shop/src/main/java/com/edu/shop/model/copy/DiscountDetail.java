package com.edu.shop.model.copy;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The persistent class for the discount_details database table.
 * 
 */
@Entity
@Table(name="discount_details")
@NamedQuery(name="DiscountDetail.findAll", query="SELECT d FROM DiscountDetail d")
public class DiscountDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int attribute;

	@Column(name="end_date")
	private Object endDate;

	private int quantity;

	@Column(name="start_date")
	private Object startDate;

	//bi-directional many-to-one association to Discount
	@ManyToOne
	private Discount discount;

	//bi-directional many-to-one association to Perfume
	@ManyToOne
	private Perfume perfume;

	public DiscountDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAttribute() {
		return this.attribute;
	}

	public void setAttribute(int attribute) {
		this.attribute = attribute;
	}

	public Object getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Object endDate) {
		this.endDate = endDate;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Object getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Object startDate) {
		this.startDate = startDate;
	}

	public Discount getDiscount() {
		return this.discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Perfume getPerfume() {
		return this.perfume;
	}

	public void setPerfume(Perfume perfume) {
		this.perfume = perfume;
	}

}