package br.ucs.shopping.views.beans;

import br.ucs.shopping.ejb.intf.CrudServiceIntf;
import br.ucs.shopping.ejb.intf.CustomerServiceIntf;
import br.ucs.shopping.models.Customer;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SignUpBean extends AbstractBean<Customer> {
	@EJB
	private CustomerServiceIntf customerService;

	/**
	 * @see AbstractBean#getcrudService()
	 */
	@Override
	protected CrudServiceIntf<Customer> getcrudService() {
		return customerService;
	}
}
