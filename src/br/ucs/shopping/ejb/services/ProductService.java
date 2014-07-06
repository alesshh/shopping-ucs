package br.ucs.shopping.ejb.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;

import br.ucs.shopping.ejb.intf.ProductServiceIntf;
import br.ucs.shopping.models.PaginatedRecords;
import br.ucs.shopping.models.Product;

@Stateless
public class ProductService extends AbstractCrudService<Product> implements
		ProductServiceIntf {

	/*
	 * @see ProductServiceIntf#listToStore(int, int)
	 */
	@Override
	public PaginatedRecords<Product> listToStore(int page, int max) {
		Query queryCount = getCountToStoreQuery();
		Long total = (Long) queryCount.getSingleResult();

		PaginatedRecords<Product> pagination = new PaginatedRecords<Product>(
				total.intValue(), page, max);

		Query query = getAllToStoreQuery();
		query.setFirstResult(pagination.offset());
		query.setMaxResults(max);

		pagination.setCollection(query.getResultList());

		return pagination;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ProductServiceIntf#searchToStore(java.lang.String , BigDecimal,
	 * BigDecimal, java.lang.Integer, int, int)
	 */
	@Override
	public PaginatedRecords<Product> searchToStore(String nameSearch,
			BigDecimal minPrice, BigDecimal maxPrice, Integer manufacturerId,
			int currentPage, int max) {

		Query queryCount;
		Query query;
		StringBuilder condition = new StringBuilder();
		List<String> conditionList = new ArrayList<String>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		if (nameSearch != null && !nameSearch.isEmpty()) {
			conditionList.add("lower(p.name) like lower(:name)");
			parameters.put("name", "%" + nameSearch + "%");
		}

		if (minPrice != null && maxPrice != null && (minPrice.intValue() > 0 && maxPrice.intValue() > 0)) {
			conditionList
					.add("p.stock.price >= :priceMin and p.stock.price <= :priceMax");
			parameters.put("priceMin", minPrice);
			parameters.put("priceMax", maxPrice);
		}

		if (manufacturerId != null && manufacturerId > 0) {
			conditionList.add("p.manufacturer.id = :manufacturer");
			parameters.put("manufacturer", manufacturerId);
		}

		Iterator<String> it = conditionList.iterator();

		while (it.hasNext()) {
			String c = it.next();

			if (it.hasNext()) {
				c = c + " and ";
			}
			
			condition = condition.append(c);
		}

		queryCount = em
				.createQuery("SELECT COUNT(p) FROM Product p WHERE p.stock.amount > 0 and "
						+ condition.toString());
		query = em
				.createQuery("SELECT p FROM Product p WHERE p.stock.amount > 0 and "
						+ condition.toString());

		for (String key : parameters.keySet()) {
			Object value = parameters.get(key);

			queryCount.setParameter(key, value);
			query.setParameter(key, value);
		}

		Long total = (Long) queryCount.getSingleResult();

		PaginatedRecords<Product> pagination = new PaginatedRecords<Product>(
				total.intValue(), currentPage, max);

		query.setFirstResult(pagination.offset());
		query.setMaxResults(max);

		pagination.setCollection(query.getResultList());

		return pagination;
	}

	/**
	 * @return
	 */
	protected Query getAllToStoreQuery() {
		return em
				.createQuery("SELECT p FROM Product as p where p.stock.amount > 0");
	}

	/**
	 * @return
	 */
	protected Query getCountToStoreQuery() {
		return em
				.createQuery("SELECT COUNT(p) FROM Product as p WHERE p.stock.amount > 0");
	}

}
