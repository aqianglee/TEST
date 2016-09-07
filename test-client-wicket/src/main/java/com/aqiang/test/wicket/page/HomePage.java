package com.aqiang.test.wicket.page;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.aqiang.test.service.StudentService;
<<<<<<< HEAD
import org.apache.wicket.markup.html.link.Link;
=======
>>>>>>> branch 'master' of https://github.com/aqianglee/test.git

public class HomePage extends MyPage {
	private static final long serialVersionUID = 1L;
	@SpringBean
	private StudentService studentService;
<<<<<<< HEAD
	
	public HomePage() {
		
		add(new Link<Void>("testRefrashForm") {
			private static final long serialVersionUID = 1L;
=======
>>>>>>> branch 'master' of https://github.com/aqianglee/test.git

<<<<<<< HEAD
			@Override
			public void onClick() {
				setResponsePage(new RefrashFormPage());
			}
		});
		
=======
	public HomePage() {
>>>>>>> branch 'master' of https://github.com/aqianglee/test.git
		Link<Void> prepareData = new Link<Void>("prepareData") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				studentService.prepareData();
			}
		};
		add(prepareData);
		Link<Void> listStudent = new Link<Void>("listStudents") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				setResponsePage(StudentListPage.class);
			}
		};
		add(listStudent);
	}
}
