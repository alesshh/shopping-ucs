package br.ucs.shopping.ejb.services;

import javax.ejb.Stateless;

import br.ucs.shopping.ejb.intf.ProductServiceIntf;
import br.ucs.shopping.models.Product;

@Stateless
public class ProductService extends AbstractCrudService<Product> implements
		ProductServiceIntf {

}
