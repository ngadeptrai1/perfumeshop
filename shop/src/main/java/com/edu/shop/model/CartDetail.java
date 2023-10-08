package com.edu.shop.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;


/**
 * The persistent class for the cart_details database table.
 * 
 */
@Entity
@Table(name="cart_details")
@NamedQuery(name="CartDetail.findAll", query="SELECT c FROM CartDetail c")
@Data
public class CartDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "quantity")
	private int quantity;

	//bi-directional many-to-one association to Cart
	@ManyToOne
	@JoinColumn(name ="cart_id" , referencedColumnName = "id")
	private Cart cart;

	//bi-directional many-to-one association to Perfume
	@ManyToOne
	@JoinColumn(name = "perfume_id" , referencedColumnName = "id")
	private Perfume perfume;

}