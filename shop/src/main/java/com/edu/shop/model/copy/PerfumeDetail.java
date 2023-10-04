package com.edu.shop.model.copy;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the perfume_details database table.
 * 
 */
@Entity
@Table(name="perfume_details")
@NamedQuery(name="PerfumeDetail.findAll", query="SELECT p FROM PerfumeDetail p")
public class PerfumeDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="create_date")
	private Object createDate;

	private Object description;

	private Object name;

	private int quantity;

	//bi-directional many-to-one association to Perfume
	@ManyToOne
	private Perfume perfume;

	public PerfumeDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Object getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Object createDate) {
		this.createDate = createDate;
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

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Perfume getPerfume() {
		return this.perfume;
	}

	public void setPerfume(Perfume perfume) {
		this.perfume = perfume;
	}

}