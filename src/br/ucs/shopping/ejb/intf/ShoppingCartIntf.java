package br.ucs.shopping.ejb.intf;

import br.ucs.shopping.models.CreditCard;
import br.ucs.shopping.models.Customer;
import br.ucs.shopping.models.Item;
import br.ucs.shopping.models.Product;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ShoppingCartIntf {
    public List<Item> getItems();
    public boolean checkout(Customer customer, CreditCard creditCard);
    public void addProduct(Product product, Integer amount);
    public void removeAllProducts();
    public void setItems(List<Item> items);
    
    public Double getShoppingFee();
    
    public Double getTotal();
}
