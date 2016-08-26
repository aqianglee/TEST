package com.aqiang.test.service;

import java.util.List;

import com.aqiang.test.entities.Specialty;
import com.aqiang.test.entities.Student;

public interface StudentService extends Service<Student> {

	public List<Student> getStudentsBySpecialty(Specialty specialty);

	public String getStudentsBySpecialtyJSONData(Specialty specialty);

	public void prepareData();

	public List<Student> getStudentsBySpecialtyFromWEB(String specialtyName);

	public void addStudentToWEB(Student student);

	public void createStudent(Student student);

}
