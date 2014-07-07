package br.ucs.shopping.ejb.intf;

import javax.ejb.Remote;

import br.ucs.shopping.models.CreditCard;

@Remote
public interface CreditCardServiceIntf extends CrudServiceIntf<CreditCard> {}
