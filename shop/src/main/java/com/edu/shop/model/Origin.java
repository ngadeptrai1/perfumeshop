package com.edu.shop.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


/**
 * The persistent class for the origin database table.
 * 
 */
@Entity
@Table(name="origin")
@NamedQuery(name="Origin.findAll", query="SELECT o FROM Origin o")
@Data
public class Origin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "description")
	private String description;

	@Column(name ="name")
	private String name;

	//bi-directional many-to-one association to Perfume
	@OneToMany(mappedBy="origin",fetch = FetchType.LAZY)
	private List<Perfume> perfumes;


	public Perfume addPerfume(Perfume perfume) {
		getPerfumes().add(perfume);
		perfume.setOrigin(this);

		return perfume;
	}

	public Perfume removePerfume(Perfume perfume) {
		getPerfumes().remove(perfume);
		perfume.setOrigin(null);

		return perfume;
	}

}