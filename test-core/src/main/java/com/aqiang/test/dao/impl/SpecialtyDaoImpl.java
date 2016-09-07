package com.aqiang.test.dao.impl;

import org.springframework.stereotype.Repository;

import com.aqiang.test.dao.SpecialtyDao;
import com.aqiang.test.entities.Specialty;

@Repository("specialtyDao")
public class SpecialtyDaoImpl extends DaoImpl<Specialty> implements SpecialtyDao {

}
