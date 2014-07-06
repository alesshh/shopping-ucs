package br.ucs.shopping.ejb.services;

import javax.ejb.Stateless;

import br.ucs.shopping.ejb.intf.CustomerServiceIntf;
import br.ucs.shopping.models.Customer;

@Stateless
public class CustomerService extends AbstractCrudService<Customer> implements
		CustomerServiceIntf {
}
