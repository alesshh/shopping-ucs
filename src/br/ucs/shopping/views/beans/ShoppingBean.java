package br.ucs.shopping.views.beans;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ucs.shopping.ejb.intf.CrudServiceIntf;
import br.ucs.shopping.ejb.intf.ProductServiceIntf;
import br.ucs.shopping.models.PaginatedRecords;
import br.ucs.shopping.models.Product;

@ManagedBean
@SessionScoped
public class ShoppingBean extends AbstractBean<Product> {
	private Integer manufacturerIdSearch;
	private BigDecimal priceMinSearch;
	private BigDecimal priceMaxSearch;

	@EJB
	private ProductServiceIntf productService;

	/**
	 * @return
	 */
	public List<Product> getProducts() {
		this.loadEntities(this.getCurrentPage());
		return this.getEntities();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see AbstractBean#getcrudService()
	 */
	@Override
	protected CrudServiceIntf<Product> getcrudService() {
		return productService;
	}

	/**
	 * @return
	 */
	public Integer getManufacturerIdSearch() {
		return manufacturerIdSearch;
	}

	/**
	 * @return
	 */
	public BigDecimal getPriceMinSearch() {
		return priceMinSearch;
	}

	/**
	 * @return
	 */
	public BigDecimal getPriceMaxSearch() {
		return priceMaxSearch;
	}

	/**
	 * @param manufacturerIdSearch
	 */
	public void setManufacturerIdSearch(Integer manufacturerIdSearch) {
		this.manufacturerIdSearch = manufacturerIdSearch;
	}

	/**
	 * @param priceMinSearch
	 */
	public void setPriceMinSearch(BigDecimal priceMinSearch) {
		this.priceMinSearch = priceMinSearch;
	}

	/**
	 * @param priceMaxSearch
	 */
	public void setPriceMaxSearch(BigDecimal priceMaxSearch) {
		this.priceMaxSearch = priceMaxSearch;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see AbstractBean#loadEntities(int)
	 */
	public void loadEntities(int page) {
		this.currentPage = page;
		PaginatedRecords<Product> pagination;

		if (hasNameSearch() || hasPriceSearch() || hasManufacturerSearch()) {
			pagination = productService.searchToStore(nameSearch,
					priceMinSearch, priceMaxSearch, manufacturerIdSearch,
					currentPage, PAGINATION);
		} else {
			pagination = productService.listToStore(currentPage, PAGINATION);
		}

		this.entities = pagination.getCollection();
		this.nextPage = pagination.hasNextPage();
		this.prevPage = pagination.hasPrevPage();
		this.entitiesCount = pagination.getTotal();
		this.offset = pagination.offset() + this.entities.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see AbstractBean#clearSearch()
	 */
	public String clearSearch() {
		this.priceMaxSearch = null;
		this.priceMinSearch = null;
		this.manufacturerIdSearch = null;
		
		return super.clearSearch();
	}

	/**
	 * @return
	 */
	protected boolean hasPriceSearch() {
		return (priceMinSearch != null && priceMaxSearch != null)
				&& (priceMinSearch.intValue() > 0 && priceMaxSearch.intValue() > 0);
	}

	/**
	 * @return
	 */
	protected boolean hasManufacturerSearch() {
		return manufacturerIdSearch != null && manufacturerIdSearch > 0;
	}

}
