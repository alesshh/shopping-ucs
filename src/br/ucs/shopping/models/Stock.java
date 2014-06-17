package br.ucs.shopping.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "stock_sq")
	@SequenceGenerator(name = "stock_sq", sequenceName = "sock_sq")
	private Integer id;
	@Column
	private Integer amount;
	@Column
	private BigDecimal price;

	/**
	 * 
	 */
	public Stock() {
		super();
	}

	/**
	 * @param id
	 * @param amount
	 * @param price
	 */
	public Stock(Integer id, Integer amount, BigDecimal price) {
		super();
		this.id = id;
		this.amount = amount;
		this.price = price;
	}

	/**
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return
	 */
	public Integer getAmount() {
		return amount;
	}

	/**
	 * @return
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param amount
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	/**
	 * @param price
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
