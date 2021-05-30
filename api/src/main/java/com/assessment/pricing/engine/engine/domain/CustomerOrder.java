package com.assessment.pricing.engine.engine.domain;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToMany
    @JoinTable(
      name = "customer_order_items", 
      joinColumns = @JoinColumn(name = "order_id"), 
      inverseJoinColumns = @JoinColumn(name = "item_id"))
    Set<Item> customerOrderItems;
    
    @Column(name = "final_price")
    private Double finalPrice;
    
    private LocalDateTime createdDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Item> getCustomerOrderItems() {
		return customerOrderItems;
	}

	public void setCustomerOrderItems(Set<Item> customerOrderItems) {
		this.customerOrderItems = customerOrderItems;
	}

	public Double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

}