package br.ucs.shopping.models;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class CreditCard implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "creditcard_sq")
	@SequenceGenerator(name = "creditcard_sq", sequenceName = "creditcard_sq")
	private Integer id;

	@Column
	private String company;

	@Column
	private String number;

	@Column
	private Date expirationDate;

	public CreditCard() {
	}

	public CreditCard(String company, String number, String expirationDate)
			throws ParseException {
		this.company = company;
		this.number = number;
		this.setExpirationDate(expirationDate);
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setExpirationDate(String expirationDate) throws ParseException {
		SimpleDateFormat expirationDateFormat = new SimpleDateFormat("ddMMyyyy");
		this.expirationDate = expirationDateFormat.parse(expirationDate);
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCard other = (CreditCard) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
