package br.ucs.shopping.views.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ucs.shopping.ejb.intf.CrudServiceIntf;
import br.ucs.shopping.ejb.intf.ProductServiceIntf;
import br.ucs.shopping.models.Product;

@ManagedBean
@SessionScoped
public class ShoppingBean extends AbstractBean<Product> {
	@EJB
	private ProductServiceIntf productService;

	/**
	 * @return
	 */
	public List<Product> getProducts() {
		this.loadEntities(this.getCurrentPage());
		return this.getEntities();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see AbstractBean#getcrudService()
	 */
	@Override
	protected CrudServiceIntf<Product> getcrudService() {
		return productService;
	}

}
