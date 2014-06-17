package br.ucs.shopping.ejb.services;

import javax.ejb.Stateless;

import br.ucs.shopping.ejb.intf.EmployeeServiceIntf;
import br.ucs.shopping.models.Employee;

@Stateless
public class EmployeeService extends AbstractCrudService<Employee> implements
		EmployeeServiceIntf {

}
