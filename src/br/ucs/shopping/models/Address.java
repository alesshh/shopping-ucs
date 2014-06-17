package br.ucs.shopping.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="address_sq")
	@SequenceGenerator(name="address_sq", sequenceName="address_sq")
	private Integer id;

	@Column
	private String street;

	@Column
	private Integer number;

	@Column
	private String adjunct;

	@Column
	private String city;

	@Column
	private String state;

	@Column
	private String zipcode;

	/**
	 * 
	 */
	public Address() {

	}

	/**
	 * @param street
	 * @param number
	 * @param adjunct
	 * @param city
	 * @param state
	 * @param zipcode
	 */
	public Address(String street, Integer number, String adjunct, String city,
			String state, String zipcode) {
		super();
		this.street = street;
		this.number = number;
		this.adjunct = adjunct;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	/**
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * @return
	 */
	public String getAdjunct() {
		return adjunct;
	}

	/**
	 * @param adjunct
	 */
	public void setAdjunct(String adjunct) {
		this.adjunct = adjunct;
	}

	/**
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
