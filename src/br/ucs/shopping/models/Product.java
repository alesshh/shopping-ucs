package br.ucs.shopping.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "product_sq")
	@SequenceGenerator(name = "product_sq", sequenceName = "product_sq")
	private Integer id;
	@Column
	private String name;
	@Column(columnDefinition = "TEXT")
	private String description;
	@ManyToOne
	private Manufacturer manufacturer;
	@Column
	private String imageUrl;
	@OneToOne(cascade = CascadeType.ALL)
	private Stock stock;

	/**
	 * 
	 */
	public Product() {
		this.manufacturer = new Manufacturer();
		this.stock = new Stock();
	}

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param manufacturer
	 * @param imageUrl
	 * @param stock
	 */
	public Product(Integer id, String name, String description,
			Manufacturer manufacturer, String imageUrl, Stock stock) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.manufacturer = manufacturer;
		this.imageUrl = imageUrl;
		this.stock = stock;
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
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return
	 */
	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	/**
	 * @return
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param manufacturer
	 */
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @param image
	 */
	public void setImageUrl(String image) {
		this.imageUrl = image;
	}

	/**
	 * @return
	 */
	public Stock getStock() {
		return stock;
	}

	/**
	 * @param stock
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}
}
