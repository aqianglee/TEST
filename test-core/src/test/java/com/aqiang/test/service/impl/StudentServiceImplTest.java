package com.aqiang.test.service.impl;

import java.util.List;

import org.testng.annotations.Test;

import com.aqiang.test.CoreTest;
import com.aqiang.test.entities.Specialty;
import com.aqiang.test.entities.Student;

public class StudentServiceImplTest extends CoreTest {

	@Test
	public void testGetStudentsBySpecialty() {
		Specialty specialty = createSpecialty("computer science and technology");
		Specialty specialty2 = createSpecialty("software engineering");
		createStudent("kyo", 25, specialty);
		createStudent("bobo", 23, specialty);
		createStudent("tengdiao", 23, specialty);
		createStudent("zhang san", 25, specialty2);
		createStudent("li si", 25, specialty2);

		List<Student> list = studentService.getStudentsBySpecialty(null);
		List<Student> list2 = studentService.getStudentsBySpecialty(specialty);
		List<Student> list3 = studentService.getStudentsBySpecialty(specialty2);
		assert list.size() == 5;
		assert list2.size() == 3;
		assert list3.size() == 2;

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
