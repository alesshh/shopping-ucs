package br.ucs.shopping.views.beans;

import br.ucs.shopping.ejb.intf.ShoppingCartIntf;
import br.ucs.shopping.models.CreditCard;
import br.ucs.shopping.models.Customer;
import br.ucs.shopping.models.Item;
import br.ucs.shopping.models.Product;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ShoppingCartBean  {

	@EJB
	private ShoppingCartIntf shoppingCartService;

	public String addProduct(Product product, Long amount){
	    Integer castedAmount = (int)(long)amount;
	    shoppingCartService.addProduct(product, castedAmount);
	    return "checkout.xhtml";
	}

	public List<Item> getItems() {
	    return shoppingCartService.getItems();
	}
	
	/**
	 * @return
	 */
	public Double getShoppingFee() {
		return shoppingCartService.getShoppingFee();
	}
	
	/**
	 * @return
	 */
	public Double getTotal() {
		return shoppingCartService.getTotal();
	}
	
	public void checkout(Customer customer, CreditCard creditCard) {
	    shoppingCartService.checkout(customer, creditCard);
	}

	public String removeAllProducts(){
	    shoppingCartService.removeAllProducts();
	    return "home.xhtml";
	}

}
