package br.ucs.shopping.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Manufacturer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator="manufacturer_sq")
	@SequenceGenerator(name="manufacturer_sq", sequenceName="manufacturer_sq")
	private Integer id;
	@Column
	private String name;
	@Column
	private String cnpj;
	@Column
	private String phone;
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;

	/**
	 * @param id
	 * @param name
	 * @param cnpj
	 * @param phone
	 */
	public Manufacturer(Integer id, String name, String cnpj, String phone,
			Address address) {
		super();
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;
		this.phone = phone;
		this.address = address;
	}

	/**
	 * 
	 */
	public Manufacturer() {
		super();
		this.address = new Address();
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
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @return
	 */
	public String getPhone() {
		return phone;
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
	 * @param cnpj
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
}
