package br.ucs.shopping.views.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ucs.shopping.ejb.intf.CrudServiceIntf;
import br.ucs.shopping.ejb.intf.ManufacturerServiceIntf;
import br.ucs.shopping.models.Manufacturer;

@ManagedBean
@SessionScoped
public class ManufacturerBean extends AbstractBean<Manufacturer> {

	@EJB
	private ManufacturerServiceIntf manufacturerService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see AbstractBean#getcrudService()
	 */
	@Override
	protected CrudServiceIntf<Manufacturer> getcrudService() {
		return manufacturerService;
	}

}
