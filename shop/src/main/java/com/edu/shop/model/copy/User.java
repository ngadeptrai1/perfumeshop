package com.edu.shop.model.copy;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private boolean activate;

	private String email;

	private Object fullname;

	@Column(name="phone_number")
	private String phoneNumber;

	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="user")
	private List<Account> accounts;

	public User() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getActivate() {
		return this.activate;
	}

	public void setActivate(boolean activate) {
		this.activate = activate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Object getFullname() {
		return this.fullname;
	}

	public void setFullname(Object fullname) {
		this.fullname = fullname;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setUser(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setUser(null);

		return account;
	}

}