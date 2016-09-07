package com.aqiang.test.service.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqiang.test.dao.Dao;
import com.aqiang.test.entities.Specialty;
import com.aqiang.test.entities.Student;
import com.aqiang.test.http.impl.client.JsonResponseHandler;
import com.aqiang.test.service.SpecialtyService;
import com.aqiang.test.service.StudentService;
import com.google.gson.Gson;

@Service
@Transactional
public class StudentServiceImpl extends ServiceImpl<Student> implements StudentService {

	@Autowired
	private SpecialtyService specialtyService;

	@Override
	@Resource(name = "studentDao")
	public void setDao(Dao<Student> dao) {
		this.dao = dao;
	}

	@Override
	public List<Student> getStudentsBySpecialty(Specialty specialty) {
		if (specialty == null) {
			return findByJpql("From Student");
		}
		return findByJpql("From Student s where s.specialty = ?", specialty);
	}

	@Override
	public String getStudentsBySpecialtyJSONData(Specialty specialty) {
		return new Gson().toJson(getStudentsBySpecialty(specialty));
	}

	@Override
	public void prepareData() {
		Specialty specialty = createSpecialty("计算机科学与技术");
		Specialty specialty2 = createSpecialty("软件工程");
		createStudent("kyo", 25, specialty);
		createStudent("bobo", 23, specialty);
		createStudent("tengdiao", 23, specialty);
		createStudent("zhang san", 25, specialty2);
		createStudent("li si", 25, specialty2);
	}

	private Specialty createSpecialty(String name) {
		Specialty specialty = new Specialty();
		specialty.setName(name);
		specialtyService.save(specialty);
		return specialty;
	}

	private Student createStudent(String name, Integer age, Specialty specialty) {
		Student student = new Student();
		student.setAge(age);
		student.setName(name);
		student.setSpecialty(specialty);
		save(student);
		return student;
	}

	@Override
	public List<Student> getStudentsBySpecialtyFromWEB(String specialtyName) {
		try {

			URIBuilder uriBuilder = new URIBuilder();
			uriBuilder.setScheme("http").setHost("127.0.0.1").setPort(8888).setPath("/app/getStudentsData.do")
					.setParameter("specialtyName", specialtyName);
			URI uri = uriBuilder.build();
			HttpGet get = new HttpGet(uri);
			CloseableHttpClient httpclient = HttpClients.createDefault();
			return httpclient.execute(get, new JsonResponseHandler<List<Student>>());
		} catch (Throwable e) {
		}
		return null;
	}

	@Override
	public void addStudentToWEB(Student student) {
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost post = new HttpPost("http://127.0.0.1:8888/app/saveStudent.do");
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
			pairs.add(new BasicNameValuePair("name", student.getName()));
			pairs.add(new BasicNameValuePair("age", student.getAge().toString()));
			pairs.add(new BasicNameValuePair("specialty.name", student.getSpecialty().getName()));
			post.setEntity(new UrlEncodedFormEntity(pairs, "UTF-8"));
			String execute = httpclient.execute(post, new BasicResponseHandler());
			if ("0".equals(execute)) {
				System.out.println("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createStudent(Student student) {
		Specialty specialty = student.getSpecialty();
		Specialty temp = specialtyService.getSpecialtyByName(specialty.getName());
		if (temp == null) {
			specialtyService.save(specialty);
		} else {
			student.setSpecialty(temp);
		}
		save(student);
	}

}
