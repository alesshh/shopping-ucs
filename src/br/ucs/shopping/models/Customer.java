package br.ucs.shopping.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "customer")
public class Customer extends Person {

    @OneToMany(cascade = CascadeType.ALL)
    private List<Request> requests;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CreditCard> creditcards;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Customer() {
		super();
		this.requests = new ArrayList<Request>();
		this.creditcards = new ArrayList<CreditCard>();
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
		this.requests = new ArrayList<Request>();
		this.creditcards = new ArrayList<CreditCard>();
	}

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setCreditCards(List<CreditCard> creditcards) {
        this.creditcards = creditcards;
    }

    public List<CreditCard> getCreditCards() {
        return creditcards;
    }
}
