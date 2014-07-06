package br.ucs.shopping.views.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.ucs.shopping.ejb.intf.CrudServiceIntf;
import br.ucs.shopping.ejb.intf.CustomerServiceIntf;
import br.ucs.shopping.models.Customer;

@ManagedBean
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
