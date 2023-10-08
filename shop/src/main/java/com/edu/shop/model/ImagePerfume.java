package com.edu.shop.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;


/**
 * The persistent class for the image_perfumes database table.
 * 
 */
@Entity
@Table(name="image_perfumes")
@NamedQuery(name="ImagePerfume.findAll", query="SELECT i FROM ImagePerfume i")
@Data
public class ImagePerfume implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	//bi-directional many-to-one association to Perfume
	@ManyToOne
	@JoinColumn(name = "perfume_id" ,referencedColumnName = "id")
	private Perfume perfume;


}