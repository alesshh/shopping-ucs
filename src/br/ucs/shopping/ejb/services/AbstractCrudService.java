package br.ucs.shopping.ejb.services;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.ucs.shopping.ejb.intf.CrudServiceIntf;
import br.ucs.shopping.models.PaginatedRecords;

public abstract class AbstractCrudService<T> implements CrudServiceIntf<T> {

	@PersistenceContext(unitName = "shopping-ucs")
	private EntityManager em;

	/**
	 * 
	 */
	public AbstractCrudService() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see CrudServiceIntf#list()
	 */
	@Override
	public List<T> list() {
		Query q = getAllQuery();

		return q.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see CrudServiceIntf#list(int, int)
	 */
	public PaginatedRecords<T> list(int currentPage, int maxResults) {
		Query queryCount = getCountAllQuery();
		Long total = (Long) queryCount.getSingleResult();

		PaginatedRecords<T> pagination = new PaginatedRecords<T>(
				total.intValue(), currentPage, maxResults);

		Query query = getAllQuery();
		query.setFirstResult(pagination.offset());
		query.setMaxResults(maxResults);

		pagination.setCollection(query.getResultList());

		return pagination;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see CrudServiceIntf#find(Integer)
	 */
	@Override
	public T find(Integer id) {
		return em.find(getTypeClazz(), id);
	}

	/**
	 * @see CrudServiceIntf#find(java.lang.Object)
	 */
	public T findReference(T entity) {
		try {
			Method m = entity.getClass().getMethod("getId");
			Integer id = (Integer) m.invoke(entity);

			em.getReference(getTypeClazz(), id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see CrudServiceIntf#build()
	 */
	public T build() {
		try {
			return getTypeClazz().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see CrudServiceIntf#save(java.lang.Object)
	 */
	@Override
	public T save(T entity) {
		em.merge(entity);

		return entity;
	}

	public boolean destroy(Integer id) {
		T entity = find(id);

		if (entity != null) {
			return destroy(entity);
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see CrudServiceIntf#destroy(java.lang.Object)
	 */
	@Override
	public boolean destroy(T entity) {
		em.remove(em.merge(entity));
		em.flush();
		return true;
	}

	/**
	 * @return
	 */
	private Class<T> getTypeClazz() {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType paramType = (ParameterizedType) type;
		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) paramType.getActualTypeArguments()[0];

		return clazz;
	}

	/**
	 * @return
	 */
	protected Query getAllQuery() {
		return em.createNamedQuery(getTypeClazz().getSimpleName().toString()
				+ ".all");
	}

	/**
	 * @return
	 */
	protected Query getCountAllQuery() {
		return em.createNamedQuery(getTypeClazz().getSimpleName().toString()
				+ ".countAll");
	}
}
