package br.ucs.shopping.ejb.services;

import br.ucs.shopping.ejb.intf.ShoppingCartIntf;
import br.ucs.shopping.models.CreditCard;
import br.ucs.shopping.models.Item;
import br.ucs.shopping.models.Product;
import br.ucs.shopping.models.Customer;
import br.ucs.shopping.models.Request;
import br.ucs.shopping.models.Stock;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.*;

@Stateful
public class ShoppingCartService implements ShoppingCartIntf {

	@PersistenceContext(unitName = "shopping-ucs")
	private EntityManager entityManager;

	private List<Item> items;

	public ShoppingCartService() {
		this.items = new ArrayList<Item>();
	}

	public void addProduct(Product product, Integer amount){
		Stock stock = product.getStock();
		if (amount > stock.getAmount()) {
            amount = stock.getAmount();
		}else if (amount < 0) {
            amount = 1;
		}
		this.items.add( new Item(new Integer(this.items.size()+1), amount, new Double(stock.getPrice().doubleValue()*amount), product) );
	}

	public boolean checkout(Customer customer, CreditCard creditCard){
	    // Código infalível
	    // TODO: falhar
	    for(Item item : this.items){
	        Stock stock = item.getProduct().getStock();
	        stock.setAmount(stock.getAmount() - item.getAmount());
	    }
        Request request = new Request(new Integer(customer.getRequests().size()+1), new Date(), new Double(30));
        request.setCreditCard(creditCard);
        request.setItems(this.items);
        entityManager.persist(request);
        return true;
	}

	public void removeAllProducts(){
		this.items = new ArrayList<Item>();
	}

}
