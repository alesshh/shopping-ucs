package br.ucs.shopping.ejb.intf;

import br.ucs.shopping.models.CreditCard;
import br.ucs.shopping.models.Customer;
import br.ucs.shopping.models.Product;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ShoppingCartIntf {
    public void addProduct(Product product, Integer amount);
    public boolean checkout(Customer customer, CreditCard creditCard);
    public void removeAllProducts();
}
