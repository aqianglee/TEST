package com.aqiang.test.dao;

import java.util.List;

import com.aqiang.test.entities.Identifiable;

public interface Dao {
	public void save(Identifiable t);

	public <T extends Identifiable> T marge(Identifiable t);

	public void delete(Identifiable t);

	public void batchByJpql(String jpql, Object... objects);

	public <T extends Identifiable> T find(Class<? extends Identifiable> clazz,
			Integer id);

	public List<? extends Identifiable> findByJpql(String jpql,
			Object... objects);
}
