package com.edu.shop.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;


/**
 * The persistent class for the perfume_details database table.
 * 
 */
@Entity
@Table(name="perfume_details")
@NamedQuery(name="PerfumeDetail.findAll", query="SELECT p FROM PerfumeDetail p")
@Data
public class PerfumeDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="create_date")
	private Date createDate;

	@Column(name = "description")
	private String description;

	@Column(name = "name")
	private String name;

	@Column(name = "quantity")
	private int quantity;

	//bi-directional many-to-one association to Perfume
	@OneToOne(mappedBy="perfumeDetail")
	private Perfume perfume;



}