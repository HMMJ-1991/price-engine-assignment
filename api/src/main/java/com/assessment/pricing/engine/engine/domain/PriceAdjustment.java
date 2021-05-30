package com.assessment.pricing.engine.engine.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="price_adjustment")
public class PriceAdjustment {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@ManyToOne
	@JoinColumn(name = "product_id")
    private Product product;
    
    @Column(name = "context")
	@Enumerated(EnumType.STRING)
    private Context context;
    
    @Column(name = "effective_units")
    private int effectiveUnits;
    
    @Column(name = "effective_condition")
	@Enumerated(EnumType.STRING)
    private EffectiveCondition effectiveCondition;
    
    @Column(name = "is_discount")
    private boolean isDiscount;
    
    @Column(name = "adjustment_type")
	@Enumerated(EnumType.STRING)
    private AdjustmentType adjustmentType;
    
    @Column(name = "adjustment_amount")
    private double adjustmentAmount;
    
    @Column(name = "sequence")
    private int sequence;
    
    @Column(name = "effective_type")
	@Enumerated(EnumType.STRING)
    private EffectiveType effectiveType;
    
    @ManyToMany(mappedBy = "priceAdjustments")
    private List<Item> items;

    @Column(name = "isActive")
    private boolean isActive;
    
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

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public int getEffectiveUnits() {
		return effectiveUnits;
	}

	public void setEffectiveUnits(int effectiveUnits) {
		this.effectiveUnits = effectiveUnits;
	}

	public EffectiveCondition getEffectiveCondition() {
		return effectiveCondition;
	}

	public void setEffectiveCondition(EffectiveCondition effectiveCondition) {
		this.effectiveCondition = effectiveCondition;
	}

	public boolean isDiscount() {
		return isDiscount;
	}

	public void setDiscount(boolean isDiscount) {
		this.isDiscount = isDiscount;
	}

	public AdjustmentType getAdjustmentType() {
		return adjustmentType;
	}

	public void setAdjustmentType(AdjustmentType adjustmentType) {
		this.adjustmentType = adjustmentType;
	}

	public double getAdjustmentAmount() {
		return adjustmentAmount;
	}

	public void setAdjustmentAmount(double adjustmentAmount) {
		this.adjustmentAmount = adjustmentAmount;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public EffectiveType getEffectiveType() {
		return effectiveType;
	}

	public void setEffectiveType(EffectiveType effectiveType) {
		this.effectiveType = effectiveType;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	} 
	
}
