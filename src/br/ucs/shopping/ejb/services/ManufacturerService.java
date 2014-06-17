package br.ucs.shopping.ejb.services;

import javax.ejb.Stateless;

import br.ucs.shopping.ejb.intf.ManufacturerServiceIntf;
import br.ucs.shopping.models.Manufacturer;

@Stateless
public class ManufacturerService extends AbstractCrudService<Manufacturer> implements
		ManufacturerServiceIntf {

}
