package br.ucs.shopping.ejb.intf;

import java.util.List;

import javax.ejb.Remote;

import br.ucs.shopping.models.PaginatedRecords;

@Remote
public interface CrudServiceIntf<T> {
	/**
	 * @return
	 */
	public List<T> list();

	/**
	 * @param current
	 * @return
	 */
	public PaginatedRecords<T> list(int currentPage, int maxResults);

	/**
	 * @param code
	 * @param query
	 * @param currentPage
	 * @param maxResults
	 * @return
	 */
	public PaginatedRecords<T> search(Integer code, String query,
			int currentPage, int maxResults);

	/**
	 * @param id
	 * @return
	 */
	public T find(Integer id);

	/**
	 * @param entity
	 * @return
	 */
	public T findReference(T entity);

	/**
	 * @return
	 */
	public T build();

	/**
	 * @param entity
	 * @return
	 */
	public T save(T entity);

	/**
	 * @param entity
	 * @return
	 */
	public boolean destroy(T entity);

	/**
	 * @param id
	 * @return
	 */
	public boolean destroy(Integer id);
}
