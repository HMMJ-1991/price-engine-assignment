package com.assessment.pricing.engine.engine.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cartoon_units", nullable = false)
    private Integer cartoonUnits;

    @Column(name = "cartoon_price", nullable = false)
    private Double cartoonPrice;
    
    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;

    @Column(name = "image_url", length=50000)
    private String imageUrl;
    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<PriceAdjustment> priceAdjustments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCartoonUnits() {
		return cartoonUnits;
	}

	public void setCartoonUnits(Integer cartoonUnits) {
		this.cartoonUnits = cartoonUnits;
	}

	public Double getCartoonPrice() {
		return cartoonPrice;
	}

	public void setCartoonPrice(Double cartoonPrice) {
		this.cartoonPrice = cartoonPrice;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
    
}