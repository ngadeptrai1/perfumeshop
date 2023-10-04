package com.edu.shop.model.copy;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the invoice_details database table.
 * 
 */
@Entity
@Table(name="invoice_details")
@NamedQuery(name="InvoiceDetail.findAll", query="SELECT i FROM InvoiceDetail i")
public class InvoiceDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="price_perfume")
	private BigDecimal pricePerfume;

	//bi-directional many-to-one association to Discount
	@ManyToOne
	private Discount discount;

	//bi-directional many-to-one association to Invoice
	@ManyToOne
	private Invoice invoice;

	//bi-directional many-to-one association to Perfume
	@ManyToOne
	private Perfume perfume;

	public InvoiceDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getPricePerfume() {
		return this.pricePerfume;
	}

	public void setPricePerfume(BigDecimal pricePerfume) {
		this.pricePerfume = pricePerfume;
	}

	public Discount getDiscount() {
		return this.discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Perfume getPerfume() {
		return this.perfume;
	}

	public void setPerfume(Perfume perfume) {
		this.perfume = perfume;
	}

}