package com.edu.shop.model.copy;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;


/**
 * The persistent class for the accounts database table.
 * 
 */
@Entity
@Table(name="accounts")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="account_name")
	private String accountName;

	private boolean activate;

	private String password;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to Cart
	@OneToMany(mappedBy="account")
	private List<Cart> carts;

	//bi-directional many-to-one association to Discount
	@OneToMany(mappedBy="account")
	private List<Discount> discounts;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="account1")
	private List<Invoice> invoices1;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="account2")
	private List<Invoice> invoices2;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="account")
	private List<Order> orders;

	public Account() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public boolean getActivate() {
		return this.activate;
	}

	public void setActivate(boolean activate) {
		this.activate = activate;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Cart addCart(Cart cart) {
		getCarts().add(cart);
		cart.setAccount(this);

		return cart;
	}

	public Cart removeCart(Cart cart) {
		getCarts().remove(cart);
		cart.setAccount(null);

		return cart;
	}

	public List<Discount> getDiscounts() {
		return this.discounts;
	}

	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}

	public Discount addDiscount(Discount discount) {
		getDiscounts().add(discount);
		discount.setAccount(this);

		return discount;
	}

	public Discount removeDiscount(Discount discount) {
		getDiscounts().remove(discount);
		discount.setAccount(null);

		return discount;
	}

	public List<Invoice> getInvoices1() {
		return this.invoices1;
	}

	public void setInvoices1(List<Invoice> invoices1) {
		this.invoices1 = invoices1;
	}

	public Invoice addInvoices1(Invoice invoices1) {
		getInvoices1().add(invoices1);
		invoices1.setAccount1(this);

		return invoices1;
	}

	public Invoice removeInvoices1(Invoice invoices1) {
		getInvoices1().remove(invoices1);
		invoices1.setAccount1(null);

		return invoices1;
	}

	public List<Invoice> getInvoices2() {
		return this.invoices2;
	}

	public void setInvoices2(List<Invoice> invoices2) {
		this.invoices2 = invoices2;
	}

	public Invoice addInvoices2(Invoice invoices2) {
		getInvoices2().add(invoices2);
		invoices2.setAccount2(this);

		return invoices2;
	}

	public Invoice removeInvoices2(Invoice invoices2) {
		getInvoices2().remove(invoices2);
		invoices2.setAccount2(null);

		return invoices2;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setAccount(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setAccount(null);

		return order;
	}

}