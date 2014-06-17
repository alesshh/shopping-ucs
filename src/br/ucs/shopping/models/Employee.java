package br.ucs.shopping.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(value = "employee")
public class Employee extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column
	public boolean master;

	@OneToOne(cascade = CascadeType.ALL)
	private Department department;

	/**
	 * 
	 */
	public Employee() {
		super();
		this.department = new Department();
	}

	/**
	 * @param id
	 * @param name
	 * @param birthDate
	 * @param username
	 * @param password
	 * @param phone
	 * @param address
	 * @param department
	 * @param admin
	 */
	public Employee(Integer id, String name, Date birthDate, String username,
			String password, String phone, Address address,
			Department department, boolean master) {
		super(id, name, birthDate, username, password, phone, address);
		this.department = department;
		this.master = master;
	}

	/**
	 * @return
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @return
	 */
	public boolean isMaster() {
		return master;
	}

	/**
	 * @param master
	 */
	public void setMaster(boolean master) {
		this.master = master;
	}

}
