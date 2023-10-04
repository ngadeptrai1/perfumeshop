package com.edu.shop.model.copy;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the invoices database table.
 * 
 */
@Entity
@Table(name="invoices")
@NamedQuery(name="Invoice.findAll", query="SELECT i FROM Invoice i")
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="created_date")
	private Object createdDate;

	private Object note;

	private String status;

	@Column(name="total_money")
	private BigDecimal totalMoney;

	//bi-directional many-to-one association to InvoiceDetail
	@OneToMany(mappedBy="invoice")
	private List<InvoiceDetail> invoiceDetails;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="seller_id")
	private Account account1;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="buyer_id")
	private Account account2;

	public Invoice() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Object getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Object createdDate) {
		this.createdDate = createdDate;
	}

	public Object getNote() {
		return this.note;
	}

	public void setNote(Object note) {
		this.note = note;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTotalMoney() {
		return this.totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public List<InvoiceDetail> getInvoiceDetails() {
		return this.invoiceDetails;
	}

	public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

	public InvoiceDetail addInvoiceDetail(InvoiceDetail invoiceDetail) {
		getInvoiceDetails().add(invoiceDetail);
		invoiceDetail.setInvoice(this);

		return invoiceDetail;
	}

	public InvoiceDetail removeInvoiceDetail(InvoiceDetail invoiceDetail) {
		getInvoiceDetails().remove(invoiceDetail);
		invoiceDetail.setInvoice(null);

		return invoiceDetail;
	}

	public Account getAccount1() {
		return this.account1;
	}

	public void setAccount1(Account account1) {
		this.account1 = account1;
	}

	public Account getAccount2() {
		return this.account2;
	}

	public void setAccount2(Account account2) {
		this.account2 = account2;
	}

}