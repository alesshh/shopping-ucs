package br.ucs.shopping.ejb.intf;

import javax.ejb.Remote;

import br.ucs.shopping.models.Item;
import br.ucs.shopping.models.Request;

@Remote
public interface RequestServiceIntf extends CrudServiceIntf<Request> {
	/**
	 * @param request
	 */
	public void cancel(Request request);
	/**
	 * @param request
	 */
	public void confirm(Request request);
}
