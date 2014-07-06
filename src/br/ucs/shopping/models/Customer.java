package br.ucs.shopping.models;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "customer")
public class Customer extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Customer() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param birthDate
	 * @param username
	 * @param password
	 * @param phone
	 * @param address
	 */
	public Customer(Integer id, String name, Date birthDate, String username,
			String password, String phone, Address address) {
		super(id, name, birthDate, username, password, phone, address,
				Role.USER);
	}
}
