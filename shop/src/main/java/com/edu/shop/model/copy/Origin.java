package com.edu.shop.model.copy;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the origin database table.
 * 
 */
@Entity
@Table(name="origin")
@NamedQuery(name="Origin.findAll", query="SELECT o FROM Origin o")
public class Origin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Object description;

	private Object name;

	//bi-directional many-to-one association to Perfume
	@OneToMany(mappedBy="origin")
	private List<Perfume> perfumes;

	public Origin() {
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
		perfume.setOrigin(this);

		return perfume;
	}

	public Perfume removePerfume(Perfume perfume) {
		getPerfumes().remove(perfume);
		perfume.setOrigin(null);

		return perfume;
	}

}