package com.edu.shop.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="price_perfume")
	private BigDecimal pricePerfume;

	//bi-directional many-to-one association to Invoice
	@ManyToOne
	@JoinColumn(name = "invoice_id",referencedColumnName = "id")
	@JsonManagedReference
	private Invoice invoice;

	//bi-directional many-to-one association to Perfume
	@ManyToOne
	@JoinColumn(name = "perfume_id" , referencedColumnName = "id")
	@JsonManagedReference
	private Perfume perfume;


}