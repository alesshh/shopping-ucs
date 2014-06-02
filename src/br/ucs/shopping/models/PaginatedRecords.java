package br.ucs.shopping.models;

import java.io.Serializable;
import java.util.List;

public class PaginatedRecords<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private int total;
	private int currentPage;
	private int maxResults;
	private List<T> collection;

	/**
	 * @param total
	 * @param currentPage
	 * @param maxResults
	 */
	public PaginatedRecords(int total, int currentPage, int maxResults) {
		this.total = total;
		this.currentPage = currentPage;
		this.maxResults = maxResults;
	}

	/**
	 * @return
	 */
	public int offset() {
		if (currentPage <= 1) {
			return 0;
		} else {
			return maxResults * (currentPage - 1);
		}
	}

	/**
	 * @return
	 */
	public int nextPage() {
		return currentPage + 1;
	}

	public int prevPage() {
		return currentPage - 1;
	}

	/**
	 * @return
	 */
	public boolean hasNextPage() {
		return total > (offset() + maxResults);
	}

	/**
	 * @return
	 */
	public boolean hasPrevPage() {
		return currentPage > 1;
	}

	/**
	 * @return
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @return
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * @return
	 */
	public int getMaxResults() {
		return maxResults;
	}

	/**
	 * @param total
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @param maxResults
	 */
	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	/**
	 * @return
	 */
	public List<T> getCollection() {
		return collection;
	}

	/**
	 * @param collection
	 */
	public void setCollection(List<T> collection) {
		this.collection = collection;
	}
}
