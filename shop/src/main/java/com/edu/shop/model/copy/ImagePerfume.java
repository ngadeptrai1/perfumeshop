package com.edu.shop.model.copy;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the image_perfumes database table.
 * 
 */
@Entity
@Table(name="image_perfumes")
@NamedQuery(name="ImagePerfume.findAll", query="SELECT i FROM ImagePerfume i")
public class ImagePerfume implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	//bi-directional many-to-one association to Perfume
	@ManyToOne
	private Perfume perfume;

	public ImagePerfume() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Perfume getPerfume() {
		return this.perfume;
	}

	public void setPerfume(Perfume perfume) {
		this.perfume = perfume;
	}

}