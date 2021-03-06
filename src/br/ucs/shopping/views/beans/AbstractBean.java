package br.ucs.shopping.views.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.ucs.shopping.ejb.intf.CrudServiceIntf;
import br.ucs.shopping.models.PaginatedRecords;

public abstract class AbstractBean<T> {
	final int PAGINATION = 6;
	private T entity;
	protected List<T> entities;
	protected int currentPage = 1;
	protected boolean nextPage;
	protected boolean prevPage;
	protected int entitiesCount;
	protected int offset;

	protected Integer idSearch;
	protected String nameSearch;

	/**
	 * @return
	 */
	protected abstract CrudServiceIntf<T> getcrudService();

	/**
	 * @return
	 */
	public List<T> getEntities() {
		return entities;
	}

	/**
	 * @return
	 */
	public T getEntity() {
		return entity;
	}

	/**
	 * 
	 */
	public void loadEntities() {
		loadEntities(1);
	}

	/**
	 * @param page
	 */
	public void loadEntities(int page) {
		this.currentPage = page;

		PaginatedRecords<T> pagination;

		if (hasIdSearch() || hasNameSearch()) {
			pagination = getcrudService().search(idSearch, nameSearch,
					currentPage, PAGINATION);
		} else {
			pagination = getcrudService().list(currentPage, PAGINATION);
		}

		this.entities = pagination.getCollection();
		this.nextPage = pagination.hasNextPage();
		this.prevPage = pagination.hasPrevPage();
		this.entitiesCount = pagination.getTotal();
		this.offset = pagination.offset() + this.entities.size();
	}

	/**
	 * 
	 */
	public void nextPage() {
		this.loadEntities(this.currentPage + 1);
	}

	/**
	 * 
	 */
	public void prevPage() {
		this.loadEntities(this.currentPage - 1);
	}

	/**
	 * 
	 */
	public void build() {
		this.entity = getcrudService().build();
	}

	/**
	 * @param entity
	 */
	public void edit(T entity) {
		this.entity = entity;
	}

	/**
	 * 
	 */
	public String search() {
		this.currentPage = 1;

		this.loadEntities();

		return "index";
	}

	/**
	 * @return
	 */
	public boolean hasCreate() {
		return true;
	}

	/**
	 * 
	 */
	public String clearSearch() {
		this.currentPage = 1;
		this.idSearch = null;
		this.nameSearch = null;

		this.loadEntities();

		return "index";
	}

	/**
	 * @param entity
	 */
	public void remove(T entity) {
		this.entity = entity;
		getcrudService().destroy(this.entity);

		setFlashInfo("Registro excluido com sucesso");
		loadEntities();
	}

	/**
	 * @return
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return
	 */
	public boolean getNextPage() {
		return nextPage;
	}

	/**
	 * @return
	 */
	public boolean getPrevPage() {
		return prevPage;
	}

	/**
	 * @return
	 */
	public int getOffset() {
		return offset;
	}

	/**
	 * @return
	 */
	public int getEntitiesCount() {
		return entitiesCount;
	}

	/**
	 * @return
	 */
	public Integer getIdSearch() {
		return idSearch;
	}

	/**
	 * @param id
	 */
	public void setIdSearch(Integer id) {
		this.idSearch = id;
	}

	/**
	 * @return
	 */
	public String getNameSearch() {
		return nameSearch;
	}

	/**
	 * @param name
	 */
	public void setNameSearch(String name) {
		this.nameSearch = name;
	}

	/**
	 * @throws Exception
	 * 
	 */
	public String save() throws Exception {
		if (!hasCreate()) {
			throw new Exception("Método não permitido");
		}
		getcrudService().save(entity);

		setFlashInfo("Registro salvo com sucesso!");
		loadEntities();

		return "index";
	}

	/**
	 * @return
	 */
	protected boolean hasNameSearch() {
		return nameSearch != null && !nameSearch.isEmpty();
	}

	/**
	 * @return
	 */
	protected boolean hasIdSearch() {
		return idSearch != null && idSearch > 0;
	}

	/**
	 * @return
	 */
	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	/**
	 * @return
	 */
	protected ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}

	/**
	 * @param message
	 */
	protected void setFlashInfo(String message) {
		getFacesContext().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}
}
