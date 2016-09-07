package com.aqiang.test.service;

import com.aqiang.test.entities.Specialty;

public interface SpecialtyService extends Service<Specialty> {

	public Specialty getSpecialtyByName(String specialtyName);

}
