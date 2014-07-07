package br.ucs.shopping.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Request implements Serializable {

	enum Status {
		ACCEPTED("accepted"), COMPLETED("completed"), REJECTED("rejected");

		private String name;

		/**
		 * @param name
		 */
		private Status(String name) {
			this.name = name;
		}

		/**
		 * @return
		 */
		public String getName() {
			return name;
		}
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "request_sq")
	@SequenceGenerator(name = "request_sq", sequenceName = "request_sq")
	private Integer id;

	@Column
	private Integer number;

	@Column
	private Date date;

	@Column
	private Double shippingFee;

	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Item> items;

	@OneToOne(cascade = CascadeType.ALL)
	private CreditCard creditcard;

	@Column
	private String status;

	public Request() {
		this.items = new ArrayList<Item>();
		this.creditcard = new CreditCard();
		this.status = Status.ACCEPTED.getName();
	}

	public Request(Integer number, Date date, Double shippingFee) {
		this();
		this.date = date;
		this.number = number;
		this.shippingFee = shippingFee;
		this.creditcard = new CreditCard();
		this.status = Status.ACCEPTED.getName();
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getNumber() {
		return number;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setShippingFee(Double shippingFee) {
		this.shippingFee = shippingFee;
	}

	public Double getShippingFee() {
		return shippingFee;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCreditCard(CreditCard creditcard) {
		this.creditcard = creditcard;
	}

	public CreditCard getCreditCard() {
		return creditcard;
	}

	public Double getTotalPrice() {
		Double totalPrice = new Double(0);
		for (Item item : this.getItems()) {
			totalPrice += item.getPrice();
		}
		totalPrice += this.shippingFee;
		return totalPrice;
	}

	public CreditCard getCreditcard() {
		return creditcard;
	}

	public String getStatus() {
		return status;
	}

	public void setCreditcard(CreditCard creditcard) {
		this.creditcard = creditcard;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setRejected() {
		this.status = Status.REJECTED.getName();
	}

	public void setCompleted() {
		this.status = Status.COMPLETED.getName();
	}

	/**
	 * @return
	 */
	public boolean isCompleted() {
		return Status.COMPLETED.getName().equals(this.status);
	}

	/**
	 * @return
	 */
	public boolean isRejected() {
		return Status.REJECTED.getName().equals(this.status);
	}

	/**
	 * @return
	 */
	public boolean isOpen() {
		return Status.ACCEPTED.getName().equals(this.status);
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
		Request other = (Request) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
