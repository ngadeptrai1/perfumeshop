package com.edu.shop.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@Data
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Long id;
	@Column(name="activate")
	private boolean activate;

	@Column(name="email")
	private String email;

	@Column(name = "fullname")
	private String fullname;

	@Column(name="phone_number")
	private String phoneNumber;

	//bi-directional many-to-one association to Account
	@OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
	private Account accounts;


}