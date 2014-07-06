package br.ucs.shopping.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "person")
public class Person implements Serializable {
	enum Role {
		USER("user"), ADMIN("admin"), MASTER("master");

		private String name;

		/**
		 * @param name
		 */
		Role(String name) {
			this.name = name;
		}

		/**
		 * @return
		 */
		public String getName() {
			return name;
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "person_sq")
	@SequenceGenerator(name = "person_sq", sequenceName = "person_sq")
	private Integer id;
	@Column
	private String name;
	@Column
	private Date birthDate;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String phone;
	@Column
	private String role;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	/**
	 * 
	 */
	public Person() {
		super();
		this.address = new Address();
	}

	/**
	 * @param name
	 * @param birthDate
	 * @param username
	 * @param password
	 * @param phone
	 * @param address
	 * @param role
	 */
	public Person(String name, Date birthDate, String username,
			String password, String phone, Address address, Role role) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.role = role.getName();
	}

	/**
	 * @param id
	 * @param name
	 * @param birthDate
	 * @param username
	 * @param password
	 * @param phone
	 * @param address
	 * @param role
	 */
	public Person(Integer id, String name, Date birthDate, String username,
			String password, String phone, Address address, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.role = role.getName();
	}

	/**
	 * @return
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @param role
	 */
	public void setRole(Role role) {
		this.role = role.getName();
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
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
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
	 * @param birthDate
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
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
