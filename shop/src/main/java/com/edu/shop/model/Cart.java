package com.edu.shop.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;


/**
 * The persistent class for the carts database table.
 * 
 */
@Entity
@Table(name="carts")
@NamedQuery(name="Cart.findAll", query="SELECT c FROM Cart c")
@Data
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name="created_date")
	private Date createdDate;

	@Column(name="total_price")
	private BigDecimal totalPrice;

	//bi-directional many-to-one association to CartDetail
	@OneToMany(mappedBy="cart",fetch = FetchType.LAZY)
	private List<CartDetail> cartDetails;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="account_id",referencedColumnName = "id")
	private Account account;

	//bi-directional many-to-one association to StatusCart
	@ManyToOne
	@JoinColumn(name="status_id",referencedColumnName = "id")
	private StatusCart statusCart;


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



}