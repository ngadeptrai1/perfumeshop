package com.edu.shop.model;

import java.io.Serializable;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the accounts database table.
 * 
 */
@Entity
@Table(name="accounts")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
@Getter
@Setter
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="account_name")
	private String accountName;

	@Column(name = "activate")
	private boolean activate;

	@Column(name = "password")
	private String password;

	//bi-directional many-to-one association to User
	@OneToOne
	@JoinColumn(name="user_id", referencedColumnName = "id")
	private User user;

	//bi-directional many-to-one association to Cart
	@OneToMany(mappedBy="account" , fetch = FetchType.LAZY)
	private List<Cart> carts;

	//bi-directional many-to-one association to Discount
	@OneToMany(mappedBy="account",fetch = FetchType.LAZY)
	private List<Discount> discounts;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="seller",fetch = FetchType.LAZY)
	private List<Invoice> seller;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="buyer",fetch = FetchType.LAZY)
	private List<Invoice> buyer;

}