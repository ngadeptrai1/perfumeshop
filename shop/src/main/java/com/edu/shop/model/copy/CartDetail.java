 package com.edu.shop.model.copy;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the cart_details database table.
 * 
 */
@Entity
@Table(name="cart_details")
@NamedQuery(name="CartDetail.findAll", query="SELECT c FROM CartDetail c")
public class CartDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int quantity;

	//bi-directional many-to-one association to Cart
	@ManyToOne
	private Cart cart;

	//bi-directional many-to-one association to Perfume
	@ManyToOne
	private Perfume perfume;

	public CartDetail() {
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

	public Cart getCart() {
		return this.cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Perfume getPerfume() {
		return this.perfume;
	}

	public void setPerfume(Perfume perfume) {
		this.perfume = perfume;
	}

}