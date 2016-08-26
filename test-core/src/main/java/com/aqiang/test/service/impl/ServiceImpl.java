package com.aqiang.test.service.impl;

import java.util.List;

import com.aqiang.test.dao.Dao;
import com.aqiang.test.service.Service;

public abstract class ServiceImpl<T> implements Service<T> {

	protected Dao<T> dao;

	public abstract void setDao(Dao<T> dao);

	@Override
	public void save(T t) {
		dao.save(t);
	}

	@Override
	public T marge(T t) {
		return dao.marge(t);
	}

	@Override
	public void delete(T t) {
		dao.delete(t);
	}

	@Override
	public void batchByJpql(String jpql, Object... objects) {
		dao.batchByJpql(jpql, objects);
	}

	@Override
	public T find(Integer id) {
		return dao.find(id);
	}

	@Override
	public List<T> findByJpql(String jpql, Object... objects) {
		return dao.findByJpql(jpql, objects);
	}

	@Override
	public List<? extends T> findByJpql(String jpql, List<Object> objects, int first, int max) {
		return dao.findByJpql(jpql, objects, first, max);
	}

}
