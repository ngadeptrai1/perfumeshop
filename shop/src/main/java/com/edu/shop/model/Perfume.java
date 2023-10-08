package com.edu.shop.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


/**
 * The persistent class for the perfumes database table.
 * 
 */
@Entity
@Table(name="perfumes")
@NamedQuery(name="Perfume.findAll", query="SELECT p FROM Perfume p")
@Data
public class Perfume implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//bi-directional many-to-one association to CartDetail
	@OneToMany(mappedBy="perfume",fetch = FetchType.LAZY)
	private List<CartDetail> cartDetails;

	//bi-directional many-to-one association to DiscountDetail
	@OneToOne(mappedBy="perfume",fetch = FetchType.LAZY)
	private DiscountDetail discountDetails;

	//bi-directional many-to-one association to ImagePerfume
	@OneToMany(mappedBy="perfume", fetch =  FetchType.LAZY)
	private List<ImagePerfume> imagePerfumes;

	//bi-directional many-to-one association to InvoiceDetail
	@OneToMany(mappedBy="perfume" ,fetch =  FetchType.LAZY)
	private List<InvoiceDetail> invoiceDetails;

	//bi-directional many-to-one association to PerfumePrice
	@OneToOne(mappedBy="perfume" ,fetch = FetchType.LAZY)
	private PerfumePrice perfumePrices;

	//bi-directional many-to-one association to Brand
	@ManyToOne
	@JoinColumn(name ="brand_id" , referencedColumnName = "id")
	private Brand brand;

	//bi-directional many-to-one association to Gender
	@ManyToOne
	@JoinColumn(name ="gender_id" , referencedColumnName = "id")
	private Gender gender;

	//bi-directional many-to-one association to Origin
	@ManyToOne
	@JoinColumn(name ="origin_id" , referencedColumnName = "id")
	private Origin origin;

	//bi-directional many-to-one association to PerfumeDetail
	@OneToOne
	@JoinColumn(name="perfume_detail_id",referencedColumnName = "id")
	private PerfumeDetail perfumeDetail;



}