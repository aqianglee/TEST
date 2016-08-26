package com.aqiang.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aqiang.test.entities.Specialty;
import com.aqiang.test.entities.Student;
import com.aqiang.test.service.StudentService;

public class Client {

	public static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("classpath:beans.xml", "classpath:beans-jpa-default.xml");
		StudentService studentService = ctx.getBean(StudentService.class);
		
		getStudents(studentService, null);
		getStudents(studentService, "计算机科学与技术");
		getStudents(studentService, "软件工程");

		Student student = new Student();
		student.setAge(17);
		student.setName("小明");
		Specialty specialty = new Specialty();
		specialty.setName("软件工程");
		student.setSpecialty(specialty);
		studentService.addStudentToWEB(student);

		getStudents(studentService, "软件工程");
	}

	private static void getStudents(StudentService studentService, String specialtyName) {
		List<Student> students = studentService.getStudentsBySpecialtyFromWEB(specialtyName);
		for (Student student : students) {
			System.out.println(student);
		}
		System.out.println();
	}
}
