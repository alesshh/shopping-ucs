package br.ucs.shopping.ejb.intf;

import java.math.BigDecimal;

import javax.ejb.Remote;

import br.ucs.shopping.models.PaginatedRecords;
import br.ucs.shopping.models.Product;

@Remote
public interface ProductServiceIntf extends CrudServiceIntf<Product> {
	/**
	 * @param page
	 * @param max
	 * @return
	 */
	public PaginatedRecords<Product> listToStore(int page, int max);

	/**
	 * @param nameSearch
	 * @param minPrice
	 * @param maxPrice
	 * @param manufacturerId
	 * @param currentPage
	 * @param max
	 * @return
	 */
	public PaginatedRecords<Product> searchToStore(String nameSearch,
			BigDecimal minPrice, BigDecimal maxPrice, Integer manufacturerId,
			int currentPage, int max);
}
