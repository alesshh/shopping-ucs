package br.ucs.shopping.views.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ucs.shopping.ejb.intf.CrudServiceIntf;
import br.ucs.shopping.ejb.intf.ManufacturerServiceIntf;
import br.ucs.shopping.ejb.intf.ProductServiceIntf;
import br.ucs.shopping.models.Manufacturer;
import br.ucs.shopping.models.Product;

@ManagedBean
@SessionScoped
public class ProductBean extends AbstractBean<Product> {
	@EJB
	private ProductServiceIntf productService;
	@EJB
	private ManufacturerServiceIntf manufacturerService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see AbstractBean#getcrudService()
	 */
	@Override
	protected CrudServiceIntf<Product> getcrudService() {
		return productService;
	}

	/**
	 * @return
	 */
	public List<Manufacturer> getManufacturers() {
		return manufacturerService.list();
	}

}
