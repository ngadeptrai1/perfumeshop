package com.edu.shop.model.copy;

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
	private int id;

	private boolean activated;

	private Object name;

	//bi-directional many-to-one association to DiscountDetail
	@OneToMany(mappedBy="discount")
	private List<DiscountDetail> discountDetails;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="created_person_id")
	private Account account;

	//bi-directional many-to-one association to InvoiceDetail
	@OneToMany(mappedBy="discount")
	private List<InvoiceDetail> invoiceDetails;

	public Discount() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getActivated() {
		return this.activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public Object getName() {
		return this.name;
	}

	public void setName(Object name) {
		this.name = name;
	}

	public List<DiscountDetail> getDiscountDetails() {
		return this.discountDetails;
	}

	public void setDiscountDetails(List<DiscountDetail> discountDetails) {
		this.discountDetails = discountDetails;
	}

	public DiscountDetail addDiscountDetail(DiscountDetail discountDetail) {
		getDiscountDetails().add(discountDetail);
		discountDetail.setDiscount(this);

		return discountDetail;
	}

	public DiscountDetail removeDiscountDetail(DiscountDetail discountDetail) {
		getDiscountDetails().remove(discountDetail);
		discountDetail.setDiscount(null);

		return discountDetail;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<InvoiceDetail> getInvoiceDetails() {
		return this.invoiceDetails;
	}

	public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

	public InvoiceDetail addInvoiceDetail(InvoiceDetail invoiceDetail) {
		getInvoiceDetails().add(invoiceDetail);
		invoiceDetail.setDiscount(this);

		return invoiceDetail;
	}

	public InvoiceDetail removeInvoiceDetail(InvoiceDetail invoiceDetail) {
		getInvoiceDetails().remove(invoiceDetail);
		invoiceDetail.setDiscount(null);

		return invoiceDetail;
	}

}