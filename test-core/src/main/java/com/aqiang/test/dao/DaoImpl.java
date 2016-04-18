package com.aqiang.test.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.aqiang.test.entities.Identifiable;

@Repository
public class DaoImpl implements Dao {
	@PersistenceContext
	EntityManager em;

	public void save(Identifiable t) {
		em.persist(t);
	}

	@SuppressWarnings("unchecked")
	public <T extends Identifiable> T marge(Identifiable t) {
		return (T) em.merge(t);
	}

	public void delete(Identifiable t) {
		em.remove(em.merge(t));
	}

	public void batchByJpql(String jpql, Object... objects) {
		Query query = em.createQuery(jpql);
		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i + 1, objects[i]);
		}
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public <T extends Identifiable> T find(Class<? extends Identifiable> clazz,
			Integer id) {
		return (T) em.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<? extends Identifiable> findByJpql(String jpql,
			Object... objects) {
		Query query = em.createQuery(jpql);
		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i + 1, objects[i]);
		}
		return query.getResultList();
	}

}
