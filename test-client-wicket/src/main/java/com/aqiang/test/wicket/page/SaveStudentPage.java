package com.aqiang.test.wicket.page;

import org.apache.wicket.request.IRequestParameters;
import org.apache.wicket.request.handler.TextRequestHandler;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.aqiang.test.entities.Specialty;
import com.aqiang.test.entities.Student;
import com.aqiang.test.service.StudentService;

public class SaveStudentPage extends MyPage {
	private static final long serialVersionUID = 1L;

	@SpringBean
	private StudentService studentService;

	public SaveStudentPage() {
		IRequestParameters parameters = getRequest().getPostParameters();
		String name = parameters.getParameterValue("name").toString();
		Integer age = parameters.getParameterValue("age").toInteger();
		String specialtyName = parameters.getParameterValue("specialty.name").toString();

		Student student = new Student();
		student.setName(name);
		student.setAge(age);

		Specialty specialty = new Specialty();
		specialty.setName(specialtyName);
		student.setSpecialty(specialty);
		studentService.createStudent(student);
		getRequestCycle().scheduleRequestHandlerAfterCurrent(new TextRequestHandler("0"));
	}
}
