package br.ucs.shopping.views.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import br.ucs.shopping.ejb.intf.CrudServiceIntf;
import br.ucs.shopping.ejb.intf.DepartmentServiceIntf;
import br.ucs.shopping.models.Department;

@ManagedBean
@SessionScoped
public class DepartmentBean extends AbstractBean<Department> {

	@EJB
	private DepartmentServiceIntf departmentService;

	/**
	 * 
	 */
	public DepartmentBean() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see AbstractBean#getcrudService()
	 */
	@Override
	protected CrudServiceIntf<Department> getcrudService() {
		return departmentService;
	}

}
