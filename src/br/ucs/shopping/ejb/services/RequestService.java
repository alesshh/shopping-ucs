package br.ucs.shopping.ejb.services;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.ucs.shopping.ejb.intf.RequestServiceIntf;
import br.ucs.shopping.models.Item;
import br.ucs.shopping.models.Product;
import br.ucs.shopping.models.Request;
import br.ucs.shopping.models.Stock;

@Stateless
public class RequestService extends AbstractCrudService<Request> implements
		RequestServiceIntf {

	/*
	 * (non-Javadoc)
	 * 
	 * @see RequestServiceIntf#cancel(Request)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void cancel(Request request) {
		request.setRejected();

		for (Item item : request.getItems()) {
			cancelItem(item);
		}

		em.merge(request);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see RequestServiceIntf#confirm(Request)
	 */
	@Override
	public void confirm(Request request) {
		request.setCompleted();

		em.merge(request);

	}

	/**
	 * @param item
	 */
	private void cancelItem(Item item) {
		Product product = item.getProduct();
		Stock stock = product.getStock();
		Integer amount = stock.getAmount();

		stock.setAmount(amount + item.getAmount());
		em.merge(stock);
	}

}
