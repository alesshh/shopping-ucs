package br.ucs.shopping.views.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.ucs.shopping.ejb.intf.CrudServiceIntf;

public abstract class AbstractBean<T> {
	private T entity;
	private List<T> entities;

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
		this.entities = getcrudService().list();
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
	 * @param entity
	 */
	public void remove(T entity) {
		this.entity = entity;
		getcrudService().destroy(this.entity);
		
		setFlashInfo("Registro excluido com sucesso");
		loadEntities();
	}
	
	/**
	 * 
	 */
	public String save() {
		getcrudService().save(entity);
		
		setFlashInfo("Registro salvo com sucesso!");
		loadEntities();
		
		return "index";
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
