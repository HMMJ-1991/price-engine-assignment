package com.assessment.pricing.engine.engine.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@ManyToOne
	@JoinColumn(name = "product_id")
    private Product product;
    
    @Column(name = "total_uints")
    private int totalUnits;
    
    @Column(name = "remaining_units")
    private int remainingUnits;
    
    @Column(name = "number_of_cartoons")
    private int numberOfCartoons;
    
    @Column(name = "item_total")
    private Double itemTotal;
    
    @ManyToMany
    @JoinTable(
    		  name = "item_price_adjustment", 
    		  joinColumns = @JoinColumn(name = "item_id"), 
    		  inverseJoinColumns = @JoinColumn(name = "price_adjustment_id"))
    private List<PriceAdjustment> priceAdjustments; 
    
    @ManyToMany(mappedBy="customerOrderItems")
    Set<CustomerOrder> custemerOrders;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getTotalUnits() {
		return totalUnits;
	}

	public void setTotalUnits(int totalUnits) {
		this.totalUnits = totalUnits;
	}

	public int getRemainingUnits() {
		return remainingUnits;
	}

	public void setRemainingUnits(int remainingUnits) {
		this.remainingUnits = remainingUnits;
	}

	public int getNumberOfCartoons() {
		return numberOfCartoons;
	}

	public void setNumberOfCartoons(int numberOfCartoons) {
		this.numberOfCartoons = numberOfCartoons;
	}

	public Double getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(Double itemTotal) {
		this.itemTotal = itemTotal;
	}

	public List<PriceAdjustment> getPriceAdjustments() {
		return priceAdjustments;
	}

	public void setPriceAdjustments(List<PriceAdjustment> priceAdjustments) {
		this.priceAdjustments = priceAdjustments;
	}

	public Set<CustomerOrder> getCustemerOrders() {
		return custemerOrders;
	}

	public void setCustemerOrders(Set<CustomerOrder> custemerOrders) {
		this.custemerOrders = custemerOrders;
	}
    
}
