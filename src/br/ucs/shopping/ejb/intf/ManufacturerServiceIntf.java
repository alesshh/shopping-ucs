package br.ucs.shopping.ejb.intf;

import javax.ejb.Remote;

import br.ucs.shopping.models.Manufacturer;

@Remote
public interface ManufacturerServiceIntf extends CrudServiceIntf<Manufacturer> {

}
