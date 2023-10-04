package com.edu.shop.model.copy;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the order_details database table.
 * 
 */
@Entity
@Table(name="order_details")
@NamedQuery(name="OrderDetail.findAll", query="SELECT o FROM OrderDetail o")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int quantity;

	//bi-directional many-to-one association to Perfume
	@ManyToOne
	private Perfume perfume;

	public OrderDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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