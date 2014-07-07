package br.ucs.shopping.views.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ucs.shopping.ejb.intf.CrudServiceIntf;
import br.ucs.shopping.ejb.intf.CreditCardServiceIntf;
import br.ucs.shopping.models.CreditCard;

@ManagedBean
@SessionScoped
public class CreditCardBean extends AbstractBean<CreditCard> {

	@EJB
	private CreditCardServiceIntf creditCardService;

	/*
	 * (non-Javadoc)
	 *
	 * @see AbstractBean#getcrudService()
	 */
	@Override
	protected CrudServiceIntf<CreditCard> getcrudService() {
		return creditCardService;
	}

}
