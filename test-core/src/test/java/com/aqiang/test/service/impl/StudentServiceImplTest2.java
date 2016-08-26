package com.aqiang.test.service.impl;

import java.util.List;

import org.testng.annotations.Test;

import com.aqiang.test.CoreTest;
import com.aqiang.test.entities.Specialty;
import com.aqiang.test.entities.Student;

public class StudentServiceImplTest2 extends CoreTest {

	@Test
	public void testGetStudentsBySpecialtyJSONData() {
		Specialty specialty = createSpecialty("computer science and technology");
		Specialty specialty2 = createSpecialty("software engineering");
		createStudent("kyo", 25, specialty);
		createStudent("bobo", 23, specialty);
		createStudent("tengdiao", 23, specialty);
		createStudent("zhang san", 25, specialty2);
		createStudent("li si", 25, specialty2);

		System.out.println(studentService.getStudentsBySpecialtyJSONData(null));
		System.out.println(studentService.getStudentsBySpecialtyJSONData(specialty));
		System.out.println(studentService.getStudentsBySpecialtyJSONData(specialty2));

	}

	private Specialty createSpecialty(String name) {
		Specialty specialty = new Specialty();
		specialty.setName(name);
		specialtyService.save(specialty);
		return specialty;
	}

	private void createStudent(String name, Integer age, Specialty specialty) {
		Student student = new Student();
		student.setName(name);
		student.setAge(age);
		student.setSpecialty(specialty);
		studentService.save(student);
	}

}
