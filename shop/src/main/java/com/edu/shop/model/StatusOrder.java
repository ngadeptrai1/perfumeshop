package com.edu.shop.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import lombok.Data;

import java.util.List;


/**
 * The persistent class for the status_cart database table.
 * 
 */
@Entity
@Table(name="status_cart")
@NamedQuery(name="StatusCart.findAll", query="SELECT s FROM StatusCart s")
@Data
public class StatusCart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String status;

	//bi-directional many-to-one association to Cart
	@OneToMany(mappedBy="statusCart")
	@JsonBackReference
	private List<Cart> carts;



}