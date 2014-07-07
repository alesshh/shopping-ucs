package br.ucs.shopping.views.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ucs.shopping.ejb.intf.CrudServiceIntf;
import br.ucs.shopping.ejb.intf.RequestServiceIntf;
import br.ucs.shopping.models.Request;

@ManagedBean
@SessionScoped
public class RequestBean extends AbstractBean<Request> {
	@EJB
	private RequestServiceIntf requestService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see AbstractBean#getcrudService()
	 */
	@Override
	protected CrudServiceIntf<Request> getcrudService() {
		return requestService;
	}

	/**
	 * @param request
	 * @return
	 */
	public String cancel(Request request) {
		requestService.cancel(request);
		this.loadEntities();

		return "index.xhtml";
	}

	/**
	 * @param request
	 * @return
	 */
	public String confirm(Request request) {
		requestService.confirm(request);
		this.loadEntities();

		return "index.xhtml";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see AbstractBean#hasCreate()
	 */
	public boolean hasCreate() {
		return false;
	}

}
