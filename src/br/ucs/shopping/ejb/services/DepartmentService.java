package br.ucs.shopping.ejb.services;

import javax.ejb.Stateless;

import br.ucs.shopping.ejb.intf.DepartmentServiceIntf;
import br.ucs.shopping.models.Department;

@Stateless
public class DepartmentService extends AbstractCrudService<Department>
		implements DepartmentServiceIntf {

}
