package br.ucs.shopping.ejb.intf;

import javax.ejb.Remote;

import br.ucs.shopping.models.Customer;

@Remote
public interface CustomerServiceIntf extends CrudServiceIntf<Customer> {

}
