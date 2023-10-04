package com.edu.shop.model.copy;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the gender database table.
 * 
 */
@Entity
@Table(name="gender")
@NamedQuery(name="Gender.findAll", query="SELECT g FROM Gender g")
public class Gender implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private boolean gender;

	//bi-directional many-to-one association to Perfume
	@OneToMany(mappedBy="gender")
	private List<Perfume> perfumes;

	public Gender() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean getGender() {
		return this.gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public List<Perfume> getPerfumes() {
		return this.perfumes;
	}

	public void setPerfumes(List<Perfume> perfumes) {
		this.perfumes = perfumes;
	}

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