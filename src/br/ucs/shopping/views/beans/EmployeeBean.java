package br.ucs.shopping.views.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ucs.shopping.ejb.intf.CrudServiceIntf;
import br.ucs.shopping.ejb.intf.DepartmentServiceIntf;
import br.ucs.shopping.ejb.intf.EmployeeServiceIntf;
import br.ucs.shopping.models.Department;
import br.ucs.shopping.models.Employee;

@ManagedBean
@SessionScoped
public class EmployeeBean extends AbstractBean<Employee> {
	@EJB
	private EmployeeServiceIntf employeeService;
	@EJB
	private DepartmentServiceIntf departmentService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see AbstractBean#getcrudService()
	 */
	@Override
	protected CrudServiceIntf<Employee> getcrudService() {
		return employeeService;
	}

	/**
	 * @return
	 */
	public List<Department> getDepartments() {
		return departmentService.list();
	}
}
