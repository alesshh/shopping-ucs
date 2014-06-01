package br.ucs.shopping.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class SiteUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String name;

	@Column
	private String email;

	@Column
	private String password;

	@Column
	private Date birth;

	@Column
	private String phone;

	@OneToOne
	private Address address;

	/**
	 * 
	 */
	public SiteUser() {
		this.address = new Address();
	}

	/**
	 * @param name
	 * @param email
	 * @param password
	 * @param birth
	 * @param phone
	 */
	public SiteUser(String name, String email, String password, Date birth,
			String phone, Address address) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.birth = birth;
		this.phone = phone;
		this.address = address;
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
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return
	 */
	public Date getBirth() {
		return birth;
	}

	/**
	 * @param birth
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	/**
	 * @return
	 */
	public String getPhone() {
		return phone;
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
