package com.edu.shop.model.copy;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the carts database table.
 * 
 */
@Entity
@Table(name="carts")
@NamedQuery(name="Cart.findAll", query="SELECT c FROM Cart c")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="created_date")
	private Object createdDate;

	//bi-directional many-to-one association to CartDetail
	@OneToMany(mappedBy="cart")
	private List<CartDetail> cartDetails;

	//bi-directional many-to-one association to Account
	@ManyToOne
	private Account account;

	public Cart() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Object getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Object createdDate) {
		this.createdDate = createdDate;
	}

	public List<CartDetail> getCartDetails() {
		return this.cartDetails;
	}

	public void setCartDetails(List<CartDetail> cartDetails) {
		this.cartDetails = cartDetails;
	}

	public CartDetail addCartDetail(CartDetail cartDetail) {
		getCartDetails().add(cartDetail);
		cartDetail.setCart(this);

		return cartDetail;
	}

	public CartDetail removeCartDetail(CartDetail cartDetail) {
		getCartDetails().remove(cartDetail);
		cartDetail.setCart(null);

		return cartDetail;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}