package com.edu.shop.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;


/**
 * The persistent class for the invoices database table.
 * 
 */
@Entity
@Table(name="invoices")
@NamedQuery(name="Invoice.findAll", query="SELECT i FROM Invoice i")
@Data
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="created_date")
	private Date createdDate;

	@Column(name="note")
	private String note;

	@Column(name ="status")
	private String status;

	@Column(name="total_money")
	private BigDecimal totalMoney;

	//bi-directional many-to-one association to InvoiceDetail
	@OneToMany(mappedBy="invoice",fetch = FetchType.LAZY)
	private List<InvoiceDetail> invoiceDetails;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="seller_id",referencedColumnName = "id")
	private Account seller;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="buyer_id",referencedColumnName = "id")
	private Account buyer;

	//bi-directional many-to-one association to Discount
	@OneToOne
	@JoinColumn(name = "discount_id" , referencedColumnName = "id")
	private Discount discount;






}