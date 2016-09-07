package com.aqiang.test.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.aqiang.test.dao.Dao;

@SuppressWarnings("unchecked")
public abstract class DaoImpl<T> implements Dao<T> {

	Class<T> clazz;

	public DaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	@PersistenceContext
	EntityManager em;

	@Override
	public void save(T t) {
		em.persist(t);
	}

	@Override
	public T marge(T t) {
		return em.merge(t);
	}

	@Override
	public void delete(T t) {
		em.remove(t);

	}

	@Override
	public void batchByJpql(String jpql, Object... objects) {
		Query query = em.createQuery(jpql);
		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i + 1, objects[i]);
		}
		query.executeUpdate();
	}

	@Override
	public T find(Integer id) {
		return em.find(clazz, id);
	}

	@Override
	public List<T> findByJpql(String jpql, Object... objects) {
		Query query = em.createQuery(jpql);
		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i + 1, objects[i]);
		}
		return query.getResultList();
	}

	@Override
	public List<? extends T> findByJpql(String jpql, List<Object> objects, int first, int max) {
		Query query = em.createQuery(jpql);
		if (objects != null) {
			for (int i = 0; i < objects.size(); i++) {
				query.setParameter(i + 1, objects.get(i));
			}
		}
		query.setFirstResult(first);
		query.setMaxResults(max);
		return query.getResultList();
	}

}
