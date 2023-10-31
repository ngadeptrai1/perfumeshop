package com.edu.shop.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
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
	@JsonBackReference
	private List<InvoiceDetail> invoiceDetails;


	//bi-directional many-to-one association to Discount
	@OneToOne
	@JoinColumn(name = "discount_id" , referencedColumnName = "id")
	@JsonManagedReference
	private Discount discount;






}