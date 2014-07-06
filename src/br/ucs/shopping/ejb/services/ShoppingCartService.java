package br.ucs.shopping.ejb.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ucs.shopping.ejb.intf.ShoppingCartIntf;
import br.ucs.shopping.models.CreditCard;
import br.ucs.shopping.models.Customer;
import br.ucs.shopping.models.Item;
import br.ucs.shopping.models.Product;
import br.ucs.shopping.models.Request;
import br.ucs.shopping.models.Stock;

@Stateful
public class ShoppingCartService implements ShoppingCartIntf {

	@PersistenceContext(unitName = "shopping-ucs")
	private EntityManager entityManager;

	private List<Item> items;

	public ShoppingCartService() {
		this.items = new ArrayList<Item>();
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void addProduct(Product product, Integer amount) {
		Stock stock = product.getStock();
		if (amount > stock.getAmount()) {
			amount = stock.getAmount();
		} else if (amount < 0) {
			amount = 1;
		}
		this.items.add(new Item(new Integer(this.items.size() + 1), amount,
				new Double(stock.getPrice().doubleValue() * amount), product));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.ucs.shopping.ejb.intf.ShoppingCartIntf#getShoppingFee()
	 */
	public Double getShoppingFee() {
		switch (this.items.size()) {
		case 1:
			return new Double(10);
		case 2:
			return new Double(15);
		case 3:
			return new Double(30);
		default:
			return new Double(0);
		}
	}

	public boolean checkout(Customer customer, CreditCard creditCard) {
		for (Item item : this.items) {
			Stock stock = item.getProduct().getStock();
			stock.setAmount(stock.getAmount() - item.getAmount());
		}
		Double shoppingFee = getShoppingFee();

		Request request = new Request(new Integer(
				customer.getRequests().size() + 1), new Date(), shoppingFee);
		request.setCreditCard(creditCard);
		request.setItems(this.items);
		entityManager.persist(request);
		return true;
	}

	/* (non-Javadoc)
	 * @see br.ucs.shopping.ejb.intf.ShoppingCartIntf#removeAllProducts()
	 */
	public void removeAllProducts() {
		this.items = new ArrayList<Item>();
	}

	/* (non-Javadoc)
	 * @see br.ucs.shopping.ejb.intf.ShoppingCartIntf#getTotal()
	 */
	public Double getTotal() {
		Double total = new Double(0);
		
		for (Item item : this.items) {
			total += item.getPrice();
		}
		
		total += getShoppingFee();
		
		return total;
	}
}
