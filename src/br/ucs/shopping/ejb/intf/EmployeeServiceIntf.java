package br.ucs.shopping.ejb.intf;

import javax.ejb.Remote;

import br.ucs.shopping.models.Employee;

@Remote
public interface EmployeeServiceIntf extends CrudServiceIntf<Employee> {

}
