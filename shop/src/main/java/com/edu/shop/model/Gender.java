package com.edu.shop.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


/**
 * The persistent class for the gender database table.
 * 
 */
@Entity
@Table(name="gender")
@NamedQuery(name="Gender.findAll", query="SELECT g FROM Gender g")
@Data
public class Gender implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name ="gender")
	private boolean gender;

	//bi-directional many-to-one association to Perfume
	@OneToMany(mappedBy="gender",fetch = FetchType.LAZY)
	private List<Perfume> perfumes;


	public Perfume addPerfume(Perfume perfume) {
		getPerfumes().add(perfume);
		perfume.setGender(this);

		return perfume;
	}

	public Perfume removePerfume(Perfume perfume) {
		getPerfumes().remove(perfume);
		perfume.setGender(null);

		return perfume;
	}

}