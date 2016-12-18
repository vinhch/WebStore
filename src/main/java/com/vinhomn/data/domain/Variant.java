package com.vinhomn.data.domain;

import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "variants")
public class Variant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Date createdOn;

	private Date modifiedOn;

	private String title;

	private BigDecimal price;

	private Integer quantity;

	@Column(insertable = false, updatable = false)
	private long productId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public long getProductId() {
		return productId;
	}

}
