package br.ucs.shopping.ejb.intf;

import javax.ejb.Remote;

import br.ucs.shopping.models.Department;

@Remote
public interface DepartmentServiceIntf extends CrudServiceIntf<Department> {

}
