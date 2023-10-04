package com.edu.shop.model.copy;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the perfumes database table.
 * 
 */
@Entity
@Table(name="perfumes")
@NamedQuery(name="Perfume.findAll", query="SELECT p FROM Perfume p")
public class Perfume implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to CartDetail
	@OneToMany(mappedBy="perfume")
	private List<CartDetail> cartDetails;

	//bi-directional many-to-one association to DiscountDetail
	@OneToMany(mappedBy="perfume")
	private List<DiscountDetail> discountDetails;

	//bi-directional many-to-one association to ImagePerfume
	@OneToMany(mappedBy="perfume")
	private List<ImagePerfume> imagePerfumes;

	//bi-directional many-to-one association to InvoiceDetail
	@OneToMany(mappedBy="perfume")
	private List<InvoiceDetail> invoiceDetails;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="perfume")
	private List<OrderDetail> orderDetails;

	//bi-directional many-to-one association to PerfumeDetail
	@OneToMany(mappedBy="perfume")
	private List<PerfumeDetail> perfumeDetails;

	//bi-directional many-to-one association to PerfumePrice
	@OneToMany(mappedBy="perfume")
	private List<PerfumePrice> perfumePrices;

	//bi-directional many-to-one association to Brand
	@ManyToOne
	private Brand brand;

	//bi-directional many-to-one association to Gender
	@ManyToOne
	private Gender gender;

	//bi-directional many-to-one association to Origin
	@ManyToOne
	private Origin origin;

	public Perfume() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<CartDetail> getCartDetails() {
		return this.cartDetails;
	}

	public void setCartDetails(List<CartDetail> cartDetails) {
		this.cartDetails = cartDetails;
	}

	public CartDetail addCartDetail(CartDetail cartDetail) {
		getCartDetails().add(cartDetail);
		cartDetail.setPerfume(this);

		return cartDetail;
	}

	public CartDetail removeCartDetail(CartDetail cartDetail) {
		getCartDetails().remove(cartDetail);
		cartDetail.setPerfume(null);

		return cartDetail;
	}

	public List<DiscountDetail> getDiscountDetails() {
		return this.discountDetails;
	}

	public void setDiscountDetails(List<DiscountDetail> discountDetails) {
		this.discountDetails = discountDetails;
	}

	public DiscountDetail addDiscountDetail(DiscountDetail discountDetail) {
		getDiscountDetails().add(discountDetail);
		discountDetail.setPerfume(this);

		return discountDetail;
	}

	public DiscountDetail removeDiscountDetail(DiscountDetail discountDetail) {
		getDiscountDetails().remove(discountDetail);
		discountDetail.setPerfume(null);

		return discountDetail;
	}

	public List<ImagePerfume> getImagePerfumes() {
		return this.imagePerfumes;
	}

	public void setImagePerfumes(List<ImagePerfume> imagePerfumes) {
		this.imagePerfumes = imagePerfumes;
	}

	public ImagePerfume addImagePerfume(ImagePerfume imagePerfume) {
		getImagePerfumes().add(imagePerfume);
		imagePerfume.setPerfume(this);

		return imagePerfume;
	}

	public ImagePerfume removeImagePerfume(ImagePerfume imagePerfume) {
		getImagePerfumes().remove(imagePerfume);
		imagePerfume.setPerfume(null);

		return imagePerfume;
	}

	public List<InvoiceDetail> getInvoiceDetails() {
		return this.invoiceDetails;
	}

	public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

	public InvoiceDetail addInvoiceDetail(InvoiceDetail invoiceDetail) {
		getInvoiceDetails().add(invoiceDetail);
		invoiceDetail.setPerfume(this);

		return invoiceDetail;
	}

	public InvoiceDetail removeInvoiceDetail(InvoiceDetail invoiceDetail) {
		getInvoiceDetails().remove(invoiceDetail);
		invoiceDetail.setPerfume(null);

		return invoiceDetail;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setPerfume(this);

		return orderDetail;
	}

	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setPerfume(null);

		return orderDetail;
	}

	public List<PerfumeDetail> getPerfumeDetails() {
		return this.perfumeDetails;
	}

	public void setPerfumeDetails(List<PerfumeDetail> perfumeDetails) {
		this.perfumeDetails = perfumeDetails;
	}

	public PerfumeDetail addPerfumeDetail(PerfumeDetail perfumeDetail) {
		getPerfumeDetails().add(perfumeDetail);
		perfumeDetail.setPerfume(this);

		return perfumeDetail;
	}

	public PerfumeDetail removePerfumeDetail(PerfumeDetail perfumeDetail) {
		getPerfumeDetails().remove(perfumeDetail);
		perfumeDetail.setPerfume(null);

		return perfumeDetail;
	}

	public List<PerfumePrice> getPerfumePrices() {
		return this.perfumePrices;
	}

	public void setPerfumePrices(List<PerfumePrice> perfumePrices) {
		this.perfumePrices = perfumePrices;
	}

	public PerfumePrice addPerfumePrice(PerfumePrice perfumePrice) {
		getPerfumePrices().add(perfumePrice);
		perfumePrice.setPerfume(this);

		return perfumePrice;
	}

	public PerfumePrice removePerfumePrice(PerfumePrice perfumePrice) {
		getPerfumePrices().remove(perfumePrice);
		perfumePrice.setPerfume(null);

		return perfumePrice;
	}

	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Origin getOrigin() {
		return this.origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

}