package com.aqiang.test.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.aqiang.test.dao.Dao;
import com.aqiang.test.entities.Specialty;
import com.aqiang.test.service.SpecialtyService;

@Service
@Transactional
public class SpecialtyServiceImpl extends ServiceImpl<Specialty> implements SpecialtyService {

	@Override
	@Resource(name = "specialtyDao")
	public void setDao(Dao<Specialty> dao) {
		this.dao = dao;
	}

	@Override
	public Specialty getSpecialtyByName(String specialtyName) {
		List<Specialty> specialtys = findByJpql("From Specialty s where s.name = ?", specialtyName);
		return specialtys.isEmpty() ? null : specialtys.get(0);
	}

	
}
