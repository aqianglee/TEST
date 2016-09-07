package com.aqiang.test.service;

import java.util.List;

public interface Service<T> {
	public void save(T t);

	public T marge(T t);

	public void delete(T t);

	public void batchByJpql(String jpql, Object... objects);

	public T find(Integer id);

	public List<T> findByJpql(String jpql, Object... objects);

	public List<? extends T> findByJpql(String jpql, List<Object> objects, int first, int max);
}
