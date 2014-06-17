package br.ucs.shopping.ejb.intf;

import javax.ejb.Remote;

import br.ucs.shopping.models.Product;

@Remote
public interface ProductServiceIntf extends CrudServiceIntf<Product> {

}
