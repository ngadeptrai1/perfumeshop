package com.edu.shop.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


/**
 * The persistent class for the brands database table.
 * 
 */
@Entity
@Table(name="brands")
@NamedQuery(name="Brand.findAll", query="SELECT b FROM Brand b")
@Data
public class Brand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	private String name;

	//bi-directional many-to-one association to Perfume
	@OneToMany(mappedBy="brand",fetch = FetchType.LAZY)
	private List<Perfume> perfumes;


}