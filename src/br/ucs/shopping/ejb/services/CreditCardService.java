package br.ucs.shopping.ejb.services;

import javax.ejb.Stateless;

import br.ucs.shopping.ejb.intf.CreditCardServiceIntf;
import br.ucs.shopping.models.CreditCard;

@Stateless
public class CreditCardService extends AbstractCrudService<CreditCard> implements CreditCardServiceIntf { }
