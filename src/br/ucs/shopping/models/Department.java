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
public class Department implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "department_sq")
	@SequenceGenerator(name = "department_sq", sequenceName = "department_sq")
	private Integer id;

	@Column
	private String name;

	/**
	 * 
	 */
	public Department() {
	}

	/**
	 * @param name
	 */
	public Department(String name) {
		super();
		this.name = name;
	}

	/**
	 * @param id
	 * @param name
	 */
	public Department(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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
}
