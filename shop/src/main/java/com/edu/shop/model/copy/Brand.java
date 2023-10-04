package com.edu.shop.model.copy;

import java.io.Serializable;

import java.util.List;

import jakarta.persistence.*;


/**
 * The persistent class for the brands database table.
 * 
 */
@Entity
@Table(name="brands")
@NamedQuery(name="Brand.findAll", query="SELECT b FROM Brand b")
public class Brand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Object description;

	private Object name;

	//bi-directional many-to-one association to Perfume
	@OneToMany(mappedBy="brand")
	private List<Perfume> perfumes;

	public Brand() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Object getDescription() {
		return this.description;
	}

	public void setDescription(Object description) {
		this.description = description;
	}

	public Object getName() {
		return this.name;
	}

	public void setName(Object name) {
		this.name = name;
	}

	public List<Perfume> getPerfumes() {
		return this.perfumes;
	}

	public void setPerfumes(List<Perfume> perfumes) {
		this.perfumes = perfumes;
	}

	public Perfume addPerfume(Perfume perfume) {
		getPerfumes().add(perfume);
		perfume.setBrand(this);

		return perfume;
	}

	public Perfume removePerfume(Perfume perfume) {
		getPerfumes().remove(perfume);
		perfume.setBrand(null);

		return perfume;
	}

}