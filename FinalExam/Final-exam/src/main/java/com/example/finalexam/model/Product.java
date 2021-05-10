package com.example.finalexam.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.MonetaryAmountFactory;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product {
		
	public static final CurrencyUnit CURRENCY = Monetary.getCurrency("USD");
	
	@Transient
	private MonetaryAmount price;
	
	@Transient
	private MonetaryAmountFactory<?> amountFactory = Monetary.getDefaultAmountFactory();
	
	@Transient
	private String currencyCode = CURRENCY.getCurrencyCode();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	/*@Version
	private Long version;*/
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Company company;
	
	@ManyToMany
	@JoinTable(
	  name = "categories", 
	  joinColumns = @JoinColumn(name = "product_id"), 
	  inverseJoinColumns = @JoinColumn(name = "categorie_id"))
	private List<Categorie> categories;
	
	@Column(name="price", precision=10, scale=2)
	private BigDecimal price_;
	
	private int stock;
	
	
	
	@PrePersist
	protected void onPrePersist() {
		currencyCode = price.getCurrency().getCurrencyCode();
		price_ = price.getNumber()
				.numberValue(BigDecimal.class)
				.setScale(price.getCurrency().getDefaultFractionDigits(),
						RoundingMode.HALF_EVEN);
	}

	@PostLoad
	protected void onPostLoad() {
		this.price =
				Monetary.getDefaultAmountFactory()
					.setNumber(price_)
					.setCurrency(currencyCode)
					.create();
	}

}